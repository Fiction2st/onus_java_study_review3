package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmployeeDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public List<EmployeeResponseDTO> getAlleEmployees() {

        return List.of();
    }

    @Override
    public void deleteEmployeeById(String employeeId) {

    }

    @Override
    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        return null;
    }
}
