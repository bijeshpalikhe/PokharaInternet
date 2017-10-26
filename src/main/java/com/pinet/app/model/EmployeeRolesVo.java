package com.pinet.app.model;

import java.util.Date;

public class EmployeeRolesVo{
    private Integer id;
    private Integer employeeId;
    private String userName;
    private String password;
    private String roles;

    public EmployeeRolesVo(){

    }

    public EmployeeRolesVo(Integer id, Integer employeeId, String userName, String password, String roles) {
        this.id = id;
        this.employeeId = employeeId;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
