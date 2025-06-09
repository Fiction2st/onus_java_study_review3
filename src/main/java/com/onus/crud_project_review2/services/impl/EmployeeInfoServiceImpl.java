package com.onus.crud_project_review2.services.impl;

import com.onus.crud_project_review2.dtos.employee.EmployeeInfoDTO;
import com.onus.crud_project_review2.dtos.employee.EmployeeInfoResponseDTO;
import com.onus.crud_project_review2.entities.EmployeeInfo;
import com.onus.crud_project_review2.mapper.EmployeeInfoMapper;
import com.onus.crud_project_review2.repositories.EmployeeInfoRepository;
import com.onus.crud_project_review2.services.EmployeeInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    EmployeeInfoRepository employeeInfoRepository;


    @Override
    public EmployeeInfoResponseDTO getEmployeeInfoById(String id) {
        EmployeeInfo employeeInfo = employeeInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        return EmployeeInfoMapper.mapToEmployeeResponseDTO(employeeInfo);
    }

    @Override
    public EmployeeInfoResponseDTO createEmployeeInfo(EmployeeInfoDTO employeeInfoDTO) {
        EmployeeInfo employeeInfo = EmployeeInfoMapper.mapToEmployeeInfo(employeeInfoDTO);
        EmployeeInfo newEmployeeInfo = employeeInfoRepository.save(employeeInfo);
        return EmployeeInfoMapper.mapToEmployeeResponseDTO(newEmployeeInfo);
    }

    @Override
    public List<EmployeeInfoResponseDTO> getAllEmployeeInfo() {
        List<EmployeeInfo> employeeInfoList = employeeInfoRepository.findAll();

        return employeeInfoList.stream()
                .map(EmployeeInfoMapper::mapToEmployeeResponseDTO)
                .collect(Collectors.toList());
    }
}
