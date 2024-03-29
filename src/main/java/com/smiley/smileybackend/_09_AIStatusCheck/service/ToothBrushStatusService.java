package com.smiley.smileybackend._09_AIStatusCheck.service;


import com.smiley.smileybackend._09_AIStatusCheck.dto.ToothBrushImageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@Transactional
@Slf4j
@PropertySource("classpath:application-path.properties")
public class ToothBrushStatusService extends RunPythonService{

    @Value("${property.toothbrush.image.request-path}")
    private String requestPath;
    @Value("${property.toothbrush.image.response-path}")
    private String responsePath;
    @Value("${property.toothbrush.python.learning-model}")
    private String learningModel;
    @Value("${property.toothbrush.python.learning-file}")
    private String learningFile;



    public ToothBrushImageDto toothBrushStatusCheck(String userId, MultipartFile imageFile) throws IOException {

        saveFile(userId, imageFile, requestPath);
        deleteOriginalFile(userId);
        runPython(userId);

        return getTrainedFile(userId);
    }

    // 2. 기존에 저장되어 있는 파일 삭제 ( 폴더가 아이디 이름으로 되어 있음 ) -> YOLO가 동일 이름으로 들어오면 이름을 바꿔버림
    public void deleteOriginalFile(String userId){

        File file = new File(responsePath+userId);
        if(!file.exists()){ // 기존에 저장된 파일이 없다면
            log.info("삭제할 파일이 존재하지 않습니다.");
        }
        else // 기존에 저장된 파일이 있다면 삭제 처리
        {
            if(file.isDirectory()) { //파일이 디렉토리인지 확인 -> 디렉토리가 비워있지 않다면 삭제가 안됨
                log.info("기존 파일 존재 - 삭제 진행");
                File[] files = file.listFiles();
                for( int i=0; i<files.length; i++){ // 디렉터리에 있는 내부 파일들을 모두 삭제
                    if( files[i].delete() ){ log.info("폴더 내부 파일 삭제 성공"); }
                    else{ log.info("폴더 내부 파일 삭제 실패"); }
                }
            }
            if(file.delete()){ log.info("파일삭제 성공"); }
            else{ log.info("파일삭제 실패"); }
        }
    }

    // 3. 이미지 학습 시키기
    public void runPython(String userId){

        log.info("칫솔 - 파이썬 실행");
        String imagePath = requestPath + userId + ".jpg";
        String command = String.format("python3 %s --weights %s --img 320 --conf 0.5 --project %s --source %s --name %s",
                learningFile, learningModel, responsePath, imagePath, userId).replace("\\","/");

        run(command);
    }

    // 4. 학습된 파일 가져오기
    public ToothBrushImageDto getTrainedFile(String userId){
        //String imagePath = String.format("%s\\%s.jpg", responsePath+userId, userId);
        String imagePath = String.format("%s/%s.jpg", responsePath+userId, userId);

        ToothBrushImageDto toothBrushImageDto = new ToothBrushImageDto();

        try {
            InputStream inputStream = new FileInputStream(imagePath);
            long fileSize = new File(imagePath).length();
            toothBrushImageDto.setImage(new byte[(int) fileSize]);
            while (inputStream.read(toothBrushImageDto.getImage()) > 0);
            inputStream.close();
        }catch (FileNotFoundException e) {
            log.info("파일없음");
        } catch (IOException e) {
            log.info("IOException",e);
        }

        return toothBrushImageDto;
    }
}
