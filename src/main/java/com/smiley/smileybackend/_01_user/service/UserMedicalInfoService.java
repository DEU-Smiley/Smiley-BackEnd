package com.smiley.smileybackend._01_user.service;

import com.smiley.smileybackend._05_hospital.domain.Hospital;
import com.smiley.smileybackend._01_user.domain.User;
import com.smiley.smileybackend._01_user.domain.UserMedicalInfo;
import com.smiley.smileybackend._01_user.dto.UserMedicalInfoDto;
import com.smiley.smileybackend._01_user.dto.user.MedicalInfoDto;
import com.smiley.smileybackend._00_common.exception.ErrorCode;
import com.smiley.smileybackend._00_common.exception.ErrorException;
import com.smiley.smileybackend._05_hospital.repository.HospitalRepository;
import com.smiley.smileybackend._01_user.repository.UserMedicalInfoRepository;
import com.smiley.smileybackend._01_user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserMedicalInfoService {

    private final UserMedicalInfoRepository userMedicalInfoRepository;

    private final UserRepository userRepository;

    private final HospitalRepository hospitalRepository;

    public UserMedicalInfoService(UserMedicalInfoRepository userMedicalInfoRepository,UserRepository userRepository, HospitalRepository hospitalRepository){
        this.userRepository=userRepository;
        this.userMedicalInfoRepository=userMedicalInfoRepository;
        this.hospitalRepository=hospitalRepository;
    }

    /**
     * 사용자의 ID 와 병원 ID를 가져와서 검색 후 사용자의 의료정보와 함께 UserMedicalInfo에 등록한다.
     *
     * @author : 김성찬
     * @param : 사용자 의료 정보 
     * @return : 저장된 사용자 의료 정보
     */
    public UserMedicalInfoDto savemedicalinfo(MedicalInfoDto medicalInfoDto) {
        UserMedicalInfo userMedicalInfo = userMedicalInfoRepository.save(medicalInfoDto.toEntity(getUser(medicalInfoDto.getUserNumber()), getHospital(medicalInfoDto.getHospitalhPid())));
        return new UserMedicalInfoDto(userMedicalInfo);
    }


    /**
     * 사용자의 ID(Index)로 정보를 가져온다.
     *
     * @author : 김성찬
     * @param : 사용자 Index
     * @return : 사용자 정보
     * @throws : 사용자 Index가 존재 하진 않는 경우 USER_NOT_FOUND
     */
    public User getUser(String userNumber){
        return userRepository.findById(userNumber).orElseThrow(
                () -> new ErrorException(ErrorCode.USER_NOT_FOUND)
        );
    }

    /**
     * 병원 ID로 정보를 가져온다.
     *
     * @author : 김성찬
     * @param : 병원 고유 ID
     * @return : 병원 정보
     * @throws : 병원 ID가 존재 하지 않으면 HOSPITAL_NOT_FOUND
     */
    public Hospital getHospital(String hPid){
        return hospitalRepository.findByHPid(hPid).orElseThrow(
                () -> new ErrorException(ErrorCode.HOSPITAL_NOT_FOUND)
        );
    }
}
