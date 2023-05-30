package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.User;
import com.smiley.smileybackend.domain.UserDevice;
import com.smiley.smileybackend.dto.response.UserDeviceInfoDto;
import com.smiley.smileybackend.dto.user.UserDeviceDto;
import com.smiley.smileybackend.exception.ErrorCode;
import com.smiley.smileybackend.exception.ErrorException;
import com.smiley.smileybackend.repository.UserDeviceRepository;
import com.smiley.smileybackend.repository.UserRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@ToString
@Slf4j
public class UserDeviceService {
    private final UserDeviceRepository userDeviceRepository;
    private final UserRepository userRepository;

    public UserDeviceService(UserDeviceRepository userDeviceRepository, UserRepository userRepository) {
        this.userDeviceRepository = userDeviceRepository;
        this.userRepository = userRepository;
    }

    public UserDeviceInfoDto adddevice(UserDeviceDto userDeviceDto) {
        User user = userRepository.findById(userDeviceDto.getUserId())
                .orElseThrow(() -> new ErrorException(ErrorCode.USER_NOT_FOUND));
        UserDevice userDevice;
        try {
            userDevice = userDeviceRepository.save(userDeviceDto.toEntity(user));
        } catch (DataIntegrityViolationException d) {
            throw new ErrorException(ErrorCode.DEVICE_ALREADY_REGISTER);
        }
        return new UserDeviceInfoDto(userDevice);
    }

}
