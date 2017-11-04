package com.pinet.app.repository;

import com.pinet.app.entities.EmployeeRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRolesRepository extends JpaRepository<EmployeeRolesEntity, Integer>{

}
