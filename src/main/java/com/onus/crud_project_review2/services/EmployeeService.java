package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.employee.EmployeeDTO;
import com.onus.crud_project_review2.dtos.employee.EmployeeResponseDTO;
import com.onus.crud_project_review2.dtos.PageResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeResponseDTO getEmployeeById(String employeeId);
    List<EmployeeResponseDTO> getAlleEmployees();
    void deleteEmployeeById(String employeeId);
    EmployeeResponseDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO);
    PageResponseDTO getAllEmployeeWithPagination(int pageNo, int pageSize, String sortBy, String sortDirection, String searchKeyword);
}
