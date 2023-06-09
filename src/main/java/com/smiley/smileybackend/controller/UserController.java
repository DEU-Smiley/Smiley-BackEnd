package com.smiley.smileybackend.controller;

import com.smiley.smileybackend.dto.response.UserInfoAndMedicalInfoDto;
import com.smiley.smileybackend.dto.response.UserInfoDto;
import com.smiley.smileybackend.dto.response.UserMedicalInfoDto;
import com.smiley.smileybackend.dto.user.MedicalInfoDto;
import com.smiley.smileybackend.dto.user.UserInfoUpdateDto;
import com.smiley.smileybackend.dto.user.UserLoginDto;
import com.smiley.smileybackend.service.UserMedicalInfoService;
import com.smiley.smileybackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "User Controller : 회원정보 및 사용자 의료정보")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMedicalInfoService userMedicalInfoService;

    public UserController(UserService userService, UserMedicalInfoService userMedicalInfoService){
        this.userService=userService;
        this.userMedicalInfoService=userMedicalInfoService;
    }

    @PostMapping("/users/loginBackup")
    @ApiOperation(value="로그인" , notes = "사용자는 로그인한다.")
    public ResponseEntity<UserInfoDto> loginbackup(@Valid @RequestParam String userNumber) {
        UserInfoDto userInfo = userService.login(userNumber);
        return ResponseEntity.ok(userInfo);
    }
    @PostMapping("/users/signup")
    @ApiOperation(value="회원가입" , notes = "사용자는 회원가입한다.")
    public ResponseEntity<UserInfoDto> signup(@Valid @RequestBody UserLoginDto userLoginDto) {
        UserInfoDto userInfo = userService.signUp(userLoginDto);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/login")
    @ApiOperation(value="회원가입" , notes = "사용자는 로그인한다(Test).")
    public ResponseEntity<UserInfoDto> login(@Valid @RequestBody UserLoginDto userLoginDto) {
        UserInfoDto userInfo = userService.signUptest(userLoginDto);
        return ResponseEntity.ok(userInfo);
    }

    @PostMapping("/users/medicalInfo")
    @ApiOperation(value="의료 정보 저장" , notes = "사용자의 의료정보를 저장한다.")
    public ResponseEntity<UserMedicalInfoDto> medicalinfo(@Valid @RequestBody MedicalInfoDto medicalInfoDto) {
        UserMedicalInfoDto userMedicalInfoDto = userMedicalInfoService.savemedicalinfo(medicalInfoDto);
        return ResponseEntity.ok(userMedicalInfoDto);
    }

    @PatchMapping("/users/allInfo")
    @ApiOperation(value="사용자 정보 및 의료 정보" , notes = "사용자 정보 및 의료 정보를 한 번에 받아와서 저장한다.")
    public ResponseEntity<UserInfoAndMedicalInfoDto> userinfos(@Valid @RequestBody UserInfoUpdateDto userInfosDto) {
        UserInfoAndMedicalInfoDto userInfoAndMedicalInfoDto = userService.saveuserinfos(userInfosDto);
        return ResponseEntity.ok(userInfoAndMedicalInfoDto);
    }
}