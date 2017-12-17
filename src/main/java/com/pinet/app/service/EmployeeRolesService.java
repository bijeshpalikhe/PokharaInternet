package com.pinet.app.service;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.EmployeeRolesEntity;
import com.pinet.app.model.EmployeeInfoResponse;
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

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;


    public EmployeeRolesResponse saveEmployeeRoles(EmployeeRolesVo employeeRolesVo, String employeeName) throws PokharaInternetException{
        EmployeeRolesEntity employeeRolesEntity = new EmployeeRolesEntity(employeeRolesVo);

//        employeeRolesEntity.setEmployeeId(employeeId);
        employeeRolesEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        employeeRolesEntity.setCreatedDate(utilDate);
        employeeRolesEntity.setLastModifiedBy(employeeName);
        employeeRolesEntity.setLastModifiedDate(utilDate);


        EmployeeRolesEntity savedEmployeeRoles = employeeRolesRepository.save(employeeRolesEntity);
        EmployeeRolesResponse employeeRolesResponse = new EmployeeRolesResponse(savedEmployeeRoles);
        return employeeRolesResponse;

    }

    public EmployeeRolesResponse updateEmployeeRolesById(EmployeeRolesVo employeeRolesVo, Integer employeeId, String employeeName) throws PokharaInternetException{
        EmployeeRolesEntity employeeRolesEntity = employeeRolesRepository.findOne(employeeId);
        if (employeeRolesEntity != null) {

            employeeRolesEntity.setEmployeeId(employeeId);
            employeeRolesEntity.setCreatedBy(employeeName);
            java.util.Date utilDate = new java.util.Date();
            employeeRolesEntity.setCreatedDate(utilDate);
            employeeRolesEntity.setLastModifiedBy(employeeName);
            employeeRolesEntity.setLastModifiedDate(utilDate);

            String lastModifiedBY = employeeRolesEntity.getLastModifiedBy() + "," + employeeName;
            employeeRolesEntity.setLastModifiedBy(lastModifiedBY);

            EmployeeRolesEntity savedRoles = employeeRolesRepository.save(employeeRolesEntity);
            EmployeeRolesResponse response = new EmployeeRolesResponse(savedRoles);

            return response;

        }
        return null;

    }

    public String deleteEmployeeRolesById(Integer employeeId) throws PokharaInternetException{
        EmployeeRolesEntity employeeRolesEntity = employeeRolesRepository.findOne(employeeId);
        if (employeeRolesEntity == null) {
            return null;

        }else{
            employeeRolesRepository.delete(employeeRolesEntity);
            return "Employee Roles Deleted Successfully";
        }

    }

    public EmployeeRolesResponse getEmployeeRoles(Integer employeeId) throws PokharaInternetException {
        EmployeeRolesEntity employeeRolesEntity = employeeRolesRepository.findOne(employeeId);
        if (employeeRolesEntity == null) {
            return null;
        } else {
            EmployeeRolesResponse employeeRolesResponse = new EmployeeRolesResponse(employeeRolesEntity);
            return employeeRolesResponse;

        }

    }


}
