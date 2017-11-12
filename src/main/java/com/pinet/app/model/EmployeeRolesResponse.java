package com.pinet.app.model;

import com.pinet.app.entities.EmployeeRolesEntity;

import java.util.Date;

public class EmployeeRolesResponse {
    private Integer employeeId;
    private String userName;
    private String password;
    private String roles;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public EmployeeRolesResponse(EmployeeRolesEntity employeeRolesEntity) {
        this.employeeId=employeeRolesEntity.getEmployeeId();
        this.userName=employeeRolesEntity.getUserName();
        this.password=employeeRolesEntity.getPassword();
        this.roles=employeeRolesEntity.getRoles();
        this.createdBy=employeeRolesEntity.getCreatedBy();
        this.createdDate=employeeRolesEntity.getCreatedDate();
        this.lastModifiedBy=employeeRolesEntity.getLastModifiedBy();
        this.lastModifiedDate=employeeRolesEntity.getLastModifiedDate();

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
