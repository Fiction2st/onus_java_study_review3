package com.onus.crud_project_review2.contollers;

import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import com.onus.crud_project_review2.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        List<EmployeeResponseDTO> employees = employeeService.getAlleEmployees();
        return ResponseEntity.ok(employees);
    }
}
