package com.pinet.app.model;

import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.EmployeeRolesEntity;

public class EmplyooInfoRolesWrapper {
    private EmployeeRolesEntity employeeRolesEntity;
    private EmployeeInfoEntity employeeInfoEntity;

    public EmplyooInfoRolesWrapper(EmployeeRolesEntity employeeRolesEntity, EmployeeInfoEntity employeeInfoEntity) {
        this.employeeRolesEntity = employeeRolesEntity;
        this.employeeInfoEntity = employeeInfoEntity;
    }

    public EmployeeRolesEntity getEmployeeRolesEntity() {
        return employeeRolesEntity;
    }

    public void setEmployeeRolesEntity(EmployeeRolesEntity employeeRolesEntity) {
        this.employeeRolesEntity = employeeRolesEntity;
    }

    public EmployeeInfoEntity getEmployeeInfoEntity() {
        return employeeInfoEntity;
    }

    public void setEmployeeInfoEntity(EmployeeInfoEntity employeeInfoEntity) {
        this.employeeInfoEntity = employeeInfoEntity;
    }
}
