package com.smiley.smileybackend._07_medicine.controller;

import com.smiley.smileybackend._07_medicine.dto.MedicineInfoDto;
import com.smiley.smileybackend._07_medicine.dto.MedicineInfoDtoList;
import com.smiley.smileybackend._07_medicine.service.MedicineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ToString
@RestController
@Api(tags = "Medicine Controller :  의약품 정보")
@Slf4j
public class MedicineController {
    private final MedicineService medicineService;
    public MedicineController(MedicineService medicineService){
        this.medicineService = medicineService;
    }

    @GetMapping("/medicines/{itemCode}")
    @ApiOperation(value="의약품 정보 조회" , notes = "Id 값을 통해 단일 의약품 정보를 가져온다")
    @ApiResponse(message = "약품 정보를 찾을 수 없습니다", code=423)
    public ResponseEntity<MedicineInfoDto> medicine(@PathVariable String itemCode) {
        MedicineInfoDto medicineInfoDto = medicineService.findMedicine(itemCode);
        log.info(medicineInfoDto.toString());
        return ResponseEntity.ok(medicineInfoDto);
    }

    @GetMapping("/medicines")
    @ApiOperation(value="모든 의약품 정보 조회" , notes = "모든 의약품 정보를 가져온다")
    public ResponseEntity<MedicineInfoDtoList> medicines() {
        MedicineInfoDtoList medicines = medicineService.getAll();
        return ResponseEntity.ok(medicines);
    }
}

