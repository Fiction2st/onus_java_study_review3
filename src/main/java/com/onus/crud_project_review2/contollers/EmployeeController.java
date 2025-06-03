package com.onus.crud_project_review2.contollers;

import com.onus.crud_project_review2.dtos.EmployeeDTO;
import com.onus.crud_project_review2.dtos.EmployeeResponseDTO;
import com.onus.crud_project_review2.dtos.PageResponseDTO;
import com.onus.crud_project_review2.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Cacheable( // key,value 형태로 캐시 저장함, 데이터가 새로 생성되는 경우를 고려해 업데이트 시간 고려해야함
            value = "employees",
            key = "T(java.util.Objects).hash(#pageNo, #pageSize, #sortBy, #sortDirection, #searchKeyword)"
    )

    @GetMapping("/all")
    public ResponseEntity<PageResponseDTO> getAllEmployeeWithPagination(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "firstName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(required = false) String searchKeyword
    ) {
        PageResponseDTO res = employeeService.getAllEmployeeWithPagination(pageNo, pageSize, sortBy, sortDirection, searchKeyword);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable String employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDTO));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
            @PathVariable String employeeId,
            @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employeeDTO));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok().build();
    }
}
