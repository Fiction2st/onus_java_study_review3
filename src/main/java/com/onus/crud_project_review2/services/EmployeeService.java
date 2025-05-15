package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmployeeDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeResponseDTO getEmployeeById(String employeeId);
    List<EmployeeResponseDTO> getAlleEmployees();
    void deleteEmployeeById(String employeeId);
    EmployeeResponseDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO);
}
