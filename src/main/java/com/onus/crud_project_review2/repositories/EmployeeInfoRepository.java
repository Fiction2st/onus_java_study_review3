package com.onus.crud_project_review2.repositories;

import com.onus.crud_project_review2.entities.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, String> {
    EmployeeInfo findByAddress(String address);
}
