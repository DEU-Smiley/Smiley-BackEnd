package com.smiley.smileybackend._03_dailyWearTime.repository;

import com.smiley.smileybackend._03_dailyWearTime.domain.DailyWearTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyWearTimeRepository extends JpaRepository<DailyWearTime,Integer> {
    List<DailyWearTime> findByUserUserNumberOrderByIdDesc(String userNumber, Pageable pageable);

    DailyWearTime findByUserUserNumberAndWearDate(String userNumber, LocalDate wearDate);
}
