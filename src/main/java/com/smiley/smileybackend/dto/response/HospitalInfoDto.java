package com.smiley.smileybackend.dto.response;

import com.smiley.smileybackend.domain.Hospital;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@Getter
@NoArgsConstructor
public class HospitalInfoDto {
    private Integer id;
    private Boolean isPartner;

    private String name;

    /*일련번호*/
    private String rnum;

    /*주소*/
    private String dutyAddr;

    /*병원분류*/
    private String dutyDiv;

    /*병원분류명*/
    private String dutyDivNam;

    /*응급의료기관코드*/
    private String dutyEmcls;

    /*응급의료기관코드명*/
    private String dutyEmclsName;

    /*응급실운영여부(1/2)*/
    private String dutyEryn;

    /*비고*/
    private String dutyEtc;

    /*기관설명상세*/
    private String dutyInf;

    /*건이약도*/
    private String dutyMapimg;

    /*기관명*/
    private String dutyName;

    /*대표전화번호*/
    private String dutyTel1;

    /*응급실전화번호*/
    private String dutyTel3;

    /*진료시간(월요일)종료시간*/
    private String dutyTime1c;

    /*진료시간(화요일)종료시간*/
    private String dutyTime2c;

    /*진료시간(수요일)종료시간*/
    private String dutyTime3c;

    /*진료시간(목요일)종료시간*/
    private String dutyTime4c;

    /*진료시간(금요일)종료시간*/
    private String dutyTime5c;

    /*진료시간(토요일)종료시간*/
    private String dutyTime6c;

    /*진료시간(일요일)종료시간*/
    private String dutyTime7c;

    /*진료시간(공휴일)종료시간*/
    private String dutyTime8c;

    /*진료시간(월요일)시작시간*/
    private String dutyTime1s;

    /*진료시간(화요일)시작시간*/
    private String dutyTime2s;

    /*진료시간(수요일)시작시간*/
    private String dutyTime3s;

    /*진료시간(목요일)시작시간*/
    private String dutyTime4s;

    /*진료시간(금요일)시작시간*/
    private String dutyTime5s;

    /*진료시간(토요일)시작시간*/
    private String dutyTime6s;

    /*진료시간(일요일)시작시간*/
    private String dutyTime7s;

    /*진료시간(공휴일)시작시간*/
    private String dutyTime8s;

    /*기관ID*/
    private String hpid;

    /*우편번호1*/
    private String postCdn1;

    /*우편번호2*/
    private String postCdn2;

    /*병원경도*/
    private String wgs84Lon;

    /*병원위도*/
    private String wgs84Lat;

    public HospitalInfoDto(Hospital saved) {
        this.id = saved.getId();
        this.isPartner = saved.getIsPartner();
        this.name = saved.getName();
        this.rnum = saved.getRnum();
        this.dutyAddr = saved.getDutyAddr();
        this.dutyDiv = saved.getDutyDiv();
        this.dutyDivNam = saved.getDutyDivNam();
        this.dutyEmcls = saved.getDutyEmcls();
        this.dutyEmclsName = saved.getDutyEmclsName();
        this.dutyEryn = saved.getDutyEryn();
        this.dutyEtc = saved.getDutyEtc();
        this.dutyInf = saved.getDutyInf();
        this.dutyMapimg = saved.getDutyMapimg();
        this.dutyName = saved.getDutyName();
        this.dutyTel1 = saved.getDutyTel1();
        this.dutyTel3 = saved.getDutyTel3();
        this.dutyTime1c = saved.getDutyTime1c();
        this.dutyTime2c = saved.getDutyTime2c();
        this.dutyTime3c = saved.getDutyTime3c();
        this.dutyTime4c = saved.getDutyTime4c();
        this.dutyTime5c = saved.getDutyTime5c();
        this.dutyTime6c = saved.getDutyTime6c();
        this.dutyTime7c = saved.getDutyTime7c();
        this.dutyTime8c = saved.getDutyTime8c();
        this.dutyTime1s = saved.getDutyTime1s();
        this.dutyTime2s = saved.getDutyTime2s();
        this.dutyTime3s = saved.getDutyTime3s();
        this.dutyTime4s = saved.getDutyTime4s();
        this.dutyTime5s = saved.getDutyTime5s();
        this.dutyTime6s = saved.getDutyTime6s();
        this.dutyTime7s = saved.getDutyTime7s();
        this.dutyTime8s = saved.getDutyTime8s();
        this.hpid = saved.getHpid();
        this.postCdn1 = saved.getPostCdn1();
        this.postCdn2 = saved.getPostCdn2();
        this.wgs84Lon = saved.getWgs84Lon();
        this.wgs84Lat = saved.getWgs84Lat();
    }
}