package com.onus.crud_project_review2.services;

import com.onus.crud_project_review2.dtos.EmployeeDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import com.onus.crud_project_review2.dtos.PageResponseDTO;
import com.onus.crud_project_review2.entities.Employees;
import com.onus.crud_project_review2.mapper.EmployeeMapper;
import com.onus.crud_project_review2.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Employees employees = EmployeeMapper.mapToEmployee(employeeDTO);
        employeeRepository.save(employees);

        return EmployeeMapper.mapToEmployeeResponseDTO(employees);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(String employeeId) {
        Employees employees = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.mapToEmployeeResponseDTO(employees);
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
        Employees employees = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employees);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        Employees employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        if(!employee.getEmail().equals(employeeDTO.getEmail()) && employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDepartment(employeeDTO.getDepartment());
        Employees updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeResponseDTO(updatedEmployee);
    }

    @Override
    public PageResponseDTO getAllEmployeeWithPagination(int pageNo, int pageSize, String sortBy, String sortDirection, String searchKeyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
//        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        Page<Employees> employeePage;
        if(searchKeyword == null || searchKeyword.trim().isEmpty()) {
            employeePage = employeeRepository.findAll(pageable);
        } else {
            employeePage = employeeRepository.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                    searchKeyword, searchKeyword, searchKeyword, pageable // searchKeyword 는 하나만 작성해도 된다.
            );
        }

        List<EmployeeResponseDTO> employeeResponseDTOS = employeePage.getContent()
                .stream()
                .map(EmployeeMapper::mapToEmployeeResponseDTO)
                .collect(Collectors.toList());

        return PageResponseDTO.builder()
                .content(employeeResponseDTOS)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(employeePage.getTotalPages())
                .totalSize(employeePage.getTotalElements())
                .hasNext(employeePage.hasNext())
                .hasPrevious(employeePage.hasPrevious())
                .build();
    }
}
