package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmployeeDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import com.onus.crud_project_review2.entities.Employees;
import com.onus.crud_project_review2.mapper.EmployeeMapper;
import com.onus.crud_project_review2.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

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
        List<Employees> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployeeById(String employeeId) {

    }

    @Override
    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        return null;
    }
}
