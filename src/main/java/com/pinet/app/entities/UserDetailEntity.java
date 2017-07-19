package com.pinet.app.dao;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "user_detail")
public class UserDetailEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "data")
    private String data;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "id_verified")
    private Boolean idVerified;

    @Column(name = "id_verified_by")
    private Integer idVerifiedBy;

    @Column(name = "email")
    private String  email;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Boolean getIdVerified() {
        return idVerified;
    }

    public void setIdVerified(Boolean idVerified) {
        this.idVerified = idVerified;
    }

    public Integer getIdVerifiedBy() {
        return idVerifiedBy;
    }

    public void setIdVerifiedBy(Integer idVerifiedBy) {
        this.idVerifiedBy = idVerifiedBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetailEntity() {
    }

    public UserDetailEntity(Integer userId, String name, String data, Date dob, String contactNo, Boolean idVerified, Integer idVerifiedBy, String email) {
        this.userId = userId;
        this.name = name;
        this.data = data;
        this.dob = dob;
        this.contactNo = contactNo;
        this.idVerified = idVerified;
        this.idVerifiedBy = idVerifiedBy;
        this.email = email;
    }

}
