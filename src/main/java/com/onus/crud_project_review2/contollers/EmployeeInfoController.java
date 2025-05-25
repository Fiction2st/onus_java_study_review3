package com.onus.crud_project_review2.contollers;

import com.onus.crud_project_review2.dtos.EmployeeInfoDTO;
import com.onus.crud_project_review2.dtos.EmployeeInfoResponseDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import com.onus.crud_project_review2.services.EmployeeInfoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/employeeInfo")
public class EmployeeInfoController {
    private final EmployeeInfoService employeeInfoService;

    @GetMapping
    public ResponseEntity<List<EmployeeInfoResponseDTO>> getAllEmployees(){
        List<EmployeeInfoResponseDTO> employeeInfo = employeeInfoService.getAllEmployeeInfo();
        return ResponseEntity.ok(employeeInfo);
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeInfoResponseDTO> getEmployeeInfo(@PathVariable String id) {
        return ResponseEntity.ok(employeeInfoService.getEmployeeInfoById(id));
    };

    @PostMapping
    private ResponseEntity<EmployeeInfoResponseDTO> createEmployeeInfo(
            @RequestBody EmployeeInfoDTO employeeInfoDTO){
        return ResponseEntity.ok(employeeInfoService.createEmployeeInfo(employeeInfoDTO));
    }

}
