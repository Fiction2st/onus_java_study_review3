package com.onus.crud_project_review2.mapper;

import com.onus.crud_project_review2.dtos.employee.EmployeeInfoDTO;
import com.onus.crud_project_review2.dtos.employee.EmployeeInfoResponseDTO;
import com.onus.crud_project_review2.entities.EmployeeInfo;

public class EmployeeInfoMapper {
    public static EmployeeInfo mapToEmployeeInfo(EmployeeInfoDTO employeeInfoDTO){
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setId(employeeInfoDTO.getId());
        employeeInfo.setAddress(employeeInfoDTO.getAddress());
        employeeInfo.setHobby(employeeInfoDTO.getHobby());
        employeeInfo.setGrade(employeeInfoDTO.getGrade());
        return employeeInfo;
    }

    public static EmployeeInfoResponseDTO mapToEmployeeResponseDTO(EmployeeInfo employeeInfo){
        EmployeeInfoResponseDTO employeeInfoResponseDTO = new EmployeeInfoResponseDTO();
        employeeInfoResponseDTO.setId(employeeInfo.getId());
        employeeInfoResponseDTO.setAddress(employeeInfo.getAddress());
        employeeInfoResponseDTO.setHobby(employeeInfo.getHobby());
        employeeInfoResponseDTO.setGrade(employeeInfo.getGrade());
        return employeeInfoResponseDTO;
    }
}
