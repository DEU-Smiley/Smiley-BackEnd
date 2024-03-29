package com.smiley.smileybackend._07_drug.controller;


import com.smiley.smileybackend._07_drug.dto.ContraindicatedDrugDto;
import com.smiley.smileybackend._07_drug.dto.DrugInfoDto;
import com.smiley.smileybackend._07_drug.dto.DrugInfoDtoList;
import com.smiley.smileybackend._07_drug.service.DrugService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@ToString
@RestController
@Api(tags = "Drug Controller :  의약품 정보")
@Slf4j
public class DrugController {
    private final DrugService drugService;
    public DrugController(DrugService drugService){
        this.drugService = drugService;
    }

    @GetMapping("/drugs/{itemCode}")
    @ApiOperation(value="의약품 정보 조회" , notes = "Id 값을 통해 단일 의약품 정보를 가져온다")
    @ApiResponse(message = "약품 정보를 찾을 수 없습니다", code=423)
    public ResponseEntity<DrugInfoDto> medicine(@PathVariable String itemCode) {
        DrugInfoDto drugInfoDto = drugService.findDrug(itemCode);
        log.info(drugInfoDto.toString());
        return ResponseEntity.ok(drugInfoDto);
    }

    @GetMapping("/drugs")
    @ApiOperation(value="모든 의약품 정보 조회" , notes = "모든 의약품 정보를 가져온다")
    public ResponseEntity<DrugInfoDtoList> medicines() {
        DrugInfoDtoList drugs = drugService.getAll();
        return ResponseEntity.ok(drugs);
    }

    @PostMapping("/drugs/inspection")
    @ApiOperation(value="의약품 검사" , notes = "Id 가져온다")
    public ResponseEntity<Map<String, Object>> drugInspection(@RequestBody List<String> itemCodeList) {

        Map<String, Object> inspectionResult = drugService.inspectionDrug(itemCodeList);
        return ResponseEntity.ok().body(inspectionResult);
    }



    @PostMapping("/contraindicatedDrug")
    @ApiOperation(value="금지성분 추가" , notes = "Id ")
    public void addContraindicatedDrug(@RequestBody ContraindicatedDrugDto subtance) {
        drugService.addContraindicatedDrug(subtance);
    }

    @GetMapping("/contraindicatedDrug/{itemName}")
    @ApiOperation(value="금지성분 상세 정보 가져오기" , notes = "Id ")
    public ResponseEntity<ContraindicatedDrugDto> getContraindicatedDrug(@PathVariable String itemName) {

        ContraindicatedDrugDto drug = drugService.getContraindicatedDrug(itemName);
        return ResponseEntity.ok(drug);
    }

    @GetMapping("/contraindicatedDrug2")
    @ApiOperation(value="금지성분 이름만 가져오기" , notes = "Id ")
    public ResponseEntity<List<String>> getContraindicatedDrug2() {

        List<String> drugList = drugService.getContraindicatedDrug2();
        return  ResponseEntity.ok(drugList);
    }
}

