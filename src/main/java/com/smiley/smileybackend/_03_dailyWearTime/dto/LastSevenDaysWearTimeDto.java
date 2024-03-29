package com.smiley.smileybackend._03_dailyWearTime.dto;

import com.smiley.smileybackend._03_dailyWearTime.domain.DailyWearTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class LastSevenDaysWearTimeDto {

    private LocalDate wearDate;

    private Integer totalWeartime;

    @Builder
    public LastSevenDaysWearTimeDto(LocalDate wearDate, Integer totalWeartime) {
        this.wearDate = wearDate;
        this.totalWeartime = totalWeartime;
    }

    public LastSevenDaysWearTimeDto(DailyWearTime saved) {
        this.wearDate = saved.getWearDate();
        this.totalWeartime = saved.getTotalWearTime();
    }

    public static LastSevenDaysWearTimeDto entityToDto(DailyWearTime saved) {
        return new LastSevenDaysWearTimeDto(
                saved.getWearDate(),
                saved.getTotalWearTime()
        );
    }
}
