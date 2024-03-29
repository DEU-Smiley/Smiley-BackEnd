package com.smiley.smileybackend._01_user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend._02_userDevice.domain.UserDevice;
import com.smiley.smileybackend._03_dailyWearTime.domain.DailyWearTime;
import com.smiley.smileybackend._06_booking.domain.Booking;
import com.smiley.smileybackend._10_community.post.domain.Post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_number")
    private String userNumber;

    @Column(nullable = false, length = 200, name = "phone_token")
    private String phoneToken;

    @Column(length = 45)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<UserDevice> userUserDevices;

    @OneToMany(mappedBy = "user")
    private List<DailyWearTime> userDailyWearTimes;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Booking> userBookings;

    @OneToMany(mappedBy = "user")
    private List<DailyExpStastics> userDailyExpStasticss;

    @OneToMany(mappedBy = "user")
    private List<Checklist> userChecklists;

    @ManyToMany()
    @JoinTable(
            name = "user_badge",
            joinColumns = @JoinColumn(name = "user_number"),
            inverseJoinColumns = @JoinColumn(name = "badge_id")
    )
    private List<Badge> userBadges;

    @OneToMany(mappedBy = "user")
    private List<FacialResult> userFacialResults;

    @OneToMany(mappedBy = "user")
    private List<UserMedicalInfo> userUserMedicalInfos;

    @OneToMany(mappedBy = "user")
    private List<TotalExpStastics> userTotalExpStasticss;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Builder
    public User(String userNumber, String phoneToken, String name, LocalDate birthDate, List<UserDevice> userUserDevices, List<DailyWearTime> userDailyWearTimes, List<Booking> userBookings, List<DailyExpStastics> userDailyExpStasticss, List<Checklist> userChecklists, List<Badge> userBadges, List<FacialResult> userFacialResults, List<UserMedicalInfo> userUserMedicalInfos, List<TotalExpStastics> userTotalExpStasticss, List<Post> posts) {
        this.userNumber = userNumber;
        this.phoneToken = phoneToken;
        this.name = name;
        this.birthDate = birthDate;
        this.userUserDevices = userUserDevices;
        this.userDailyWearTimes = userDailyWearTimes;
        this.userBookings = userBookings;
        this.userDailyExpStasticss = userDailyExpStasticss;
        this.userChecklists = userChecklists;
        this.userBadges = userBadges;
        this.userFacialResults = userFacialResults;
        this.userUserMedicalInfos = userUserMedicalInfos;
        this.userTotalExpStasticss = userTotalExpStasticss;
        this.posts = posts;
    }
}
