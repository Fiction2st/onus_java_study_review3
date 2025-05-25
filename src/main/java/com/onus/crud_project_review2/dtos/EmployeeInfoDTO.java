package com.onus.crud_project_review2.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDTO {
    private String id;

    @NotEmpty(message = "address should not be empty")
    private String address;

    private String hobby;
    private String grade;
}
