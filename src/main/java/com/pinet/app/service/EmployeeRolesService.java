package com.pinet.app.service;

import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.EmployeeRolesEntity;
import com.pinet.app.model.EmployeeRolesResponse;
import com.pinet.app.model.EmployeeRolesVo;
import com.pinet.app.repository.EmployeeInfoRepository;
import com.pinet.app.repository.EmployeeRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRolesService {

    @Autowired
    EmployeeRolesRepository employeeRolesRepository;
//    @Autowired
//    EmployeeInfoRepository employeeInfoRepository;

    public EmployeeRolesResponse saveEmployeeRoles(EmployeeRolesVo employeeRolesVo, Integer employeeId, String employeeName) {
        EmployeeRolesEntity employeeRolesEntity = new EmployeeRolesEntity(employeeRolesVo);

        employeeRolesEntity.setEmployeeId(employeeId);
        System.out.println("\n \n \n \n  \n EMployee id from request param : "+employeeId);

        employeeRolesEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        employeeRolesEntity.setCreatedDate(utilDate);
        employeeRolesEntity.setLastModifiedBy(employeeName);
        employeeRolesEntity.setLastModifiedDate(utilDate);

//
//        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);
//        Integer id=

        EmployeeRolesEntity savedEmployeeRoles = employeeRolesRepository.save(employeeRolesEntity);
        EmployeeRolesResponse employeeRolesResponse = new EmployeeRolesResponse(savedEmployeeRoles);
        return employeeRolesResponse;

    }
}
