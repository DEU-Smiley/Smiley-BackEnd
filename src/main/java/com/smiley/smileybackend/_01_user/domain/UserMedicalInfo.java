package com.smiley.smileybackend._01_user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smiley.smileybackend._05_hospital.domain.Hospital;
import com.smiley.smileybackend._01_user.dto.user.SurveyJsonDto;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@ToString(exclude = {"user","hospital"})
@NoArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class UserMedicalInfo implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer calibrationStatus;

    @Column
    private LocalDate startDate;

    @Type(type = "json")
    @JsonIgnore
    @Column(columnDefinition = "json")
    private List<SurveyJsonDto> surveyResult;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number", foreignKey = @ForeignKey(name = "fk_usermedicalinfo_user"))
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "hpid", foreignKey = @ForeignKey(name = "fk_usermedicalinfo_hospital"))
    })
    @JsonIgnore
    private Hospital hospital;

    @Builder
    public UserMedicalInfo(Integer id, Integer calibrationStatus, LocalDate startDate, List<SurveyJsonDto> surveyResult, User user, Hospital hospital) {
        this.id = id;
        this.calibrationStatus = calibrationStatus;
        this.startDate = startDate;
        this.surveyResult = surveyResult;
        this.user = user;
        this.hospital = hospital;
    }
}