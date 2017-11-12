package com.pinet.app.model;

import java.util.Date;

public class EmployeeRolesVo {

    private String userName;
    private String password;
    private String roles;

    public EmployeeRolesVo() {
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