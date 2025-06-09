package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.employee.EmployeeInfoDTO;
import com.onus.crud_project_review2.dtos.employee.EmployeeInfoResponseDTO;

import java.util.List;


public interface EmployeeInfoService {
    EmployeeInfoResponseDTO getEmployeeInfoById(String id);
    EmployeeInfoResponseDTO createEmployeeInfo(EmployeeInfoDTO employeeInfoDTO);
    List<EmployeeInfoResponseDTO> getAllEmployeeInfo();
}
