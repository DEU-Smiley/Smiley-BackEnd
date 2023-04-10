package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.dto.response.UserInfoDto;
import com.smiley.smileybackend.dto.user.UserLoginDto;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserInfoDto login(@Valid UserLoginDto userLoginDto) {
        User user = userRepository.findByEmail(userLoginDto.getEmail()).orElse(
                null
        );
        if (user==null){
            user = userRepository.save(userLoginDto.toEntity());
        }
        return new UserInfoDto(user);
    }
}
