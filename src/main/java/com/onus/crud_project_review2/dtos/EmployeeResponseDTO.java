package com.onus.crud_project_review2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}
