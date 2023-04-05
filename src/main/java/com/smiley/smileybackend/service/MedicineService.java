package com.smiley.smileybackend.service;

import com.smiley.smileybackend.domain.Medicine;
import com.smiley.smileybackend.dto.response.MedicineInfoDto;
import com.smiley.smileybackend.repository.MedicineRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedicineService {
    private MedicineRepository medicineRepository;

    private ModelMapper modelMapper;
    public MedicineService(MedicineRepository medicineRepository, ModelMapper modelMapper){
        this.medicineRepository = medicineRepository;
        this.modelMapper=modelMapper;
    }
    /**
     * ID 값을 통해 단일 의약품 정보를 가져온다
     * */
    public MedicineInfoDto findMedicine(Integer id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("의약품을 찾을 수 없습니다")
        );
        return new MedicineInfoDto(medicine);
    }

    /**
     * 모든 의약품 정보를 가져온다
     * */
    public List<MedicineInfoDto> getAll() {
        return medicineRepository.findAll().stream().map(medicine -> modelMapper.map(medicine,MedicineInfoDto.class)).collect(Collectors.toList());
    }
}
