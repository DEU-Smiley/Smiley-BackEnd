package com.smiley.smileybackend._09_AIStatusCheck.controller;


// 얼굴 변화 만들때는 FacialChangeController로 만들기


import com.smiley.smileybackend._09_AIStatusCheck.dto.ToothBrushImageDto;
import com.smiley.smileybackend._09_AIStatusCheck.service.ToothBrushStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@Api(tags = "Toothbrush Status Controller :  칫솔 상태 검사")
@RestController
public class ToothbrushStatusController {

    private ToothBrushStatusService toothBrushStatusService;
    public ToothbrushStatusController(ToothBrushStatusService toothBrushStatusService) { this.toothBrushStatusService = toothBrushStatusService; }

      @PostMapping("/ToothBrushStatus/{userId}")
      @ApiOperation(value="칫솔 상태 검사" , notes = "칫솔 사진과 함께 요청하면 해당 이미지를 학습하여 그 결과 이미지를 반환한다.")
      public ResponseEntity<ToothBrushImageDto> uploadFile(@PathVariable("userId") String userId , @RequestPart MultipartFile imageFile) throws IOException{
          ToothBrushImageDto toothBrushImageDto = toothBrushStatusService.toothBrushStatusCheck(userId, imageFile);
          return ResponseEntity.ok(toothBrushImageDto);
      }



}
