package com.smiley.smileybackend._06_booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.smiley.smileybackend._06_booking.domain.Booking;
import com.smiley.smileybackend._05_hospital.domain.Hospital;
import com.smiley.smileybackend._01_user.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingInfoDto {

    @NotBlank(message = "회원번호를 확인할 수 없습니다.")
    @ApiModelProperty(value = "사용자 회원번호(KAKAO,GOOGLE). 공백 X")
    private String userNumber;

    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    @ApiModelProperty(value = "예약 날짜 및 시간, 공백 X")
    private LocalDateTime reservDate;

    @ApiModelProperty(value = "예약 메모 사항, 공백 O")
    private String memo;

    @ApiModelProperty(value = "예약한 병원 hPid, 공백 X")
    private String hPid;

    public Booking toEntity(User user, Hospital hospital,String bookingNumber){
        return Booking.builder()
                .reservDate(reservDate)
                .bookingNumber(bookingNumber)
                .memo(memo)
                .user(user)
                .hospital(hospital).build();
    }
}