package com.onus.crud_project_review2.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoResponseDTO {
    private String id;
    private String address;
    private String hobby;
    private String grade;
}
