package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmployeeInfoDTO;
import com.onus.crud_project_review2.dtos.EmployeeInfoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeInfoService {
    EmployeeInfoResponseDTO getEmployeeInfoById(String id);
    EmployeeInfoResponseDTO createEmployeeInfo(EmployeeInfoDTO employeeInfoDTO);
    List<EmployeeInfoResponseDTO> getAllEmployeeInfo();
}
