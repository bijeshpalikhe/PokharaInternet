package com.pinet.app.repository;

import com.pinet.app.entities.EmployeeInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfoEntity, Integer> {

}
