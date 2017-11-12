package com.pinet.app.entities;


import com.pinet.app.model.EmployeeRolesVo;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

        /*
        *Created by bijesh on 7/17/2017.
        *Table to store Employee info
        * */


@Entity
@Table(name = "employee_roles")
public class EmployeeRolesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name = "UNAME")
    private String username;

    @Column(name = "PWD")
    private String password;

    @Column(name = "ROLES")
    private String roles;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;


    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedBy
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    public EmployeeRolesEntity() {
    }

    public EmployeeRolesEntity(EmployeeRolesVo employeeRolesVo) {
//        this.employeeId=employeeRolesVo.getEmployeeId();
        /* userName;
        private String password;
        private String roles; */
        this.username=employeeRolesVo.getUserName();
        this.password=employeeRolesVo.getPassword();
        this.roles=employeeRolesVo.getRoles();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
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
