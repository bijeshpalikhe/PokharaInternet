package com.pinet.app.entities;


import com.pinet.app.model.ClientVO;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

        /*
        *Created by bijesh on 7/17/2017.
        *Table to store client  info
        * */


@Entity
@Table(name = "client_data")
public class ClientDataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "CLIENT_DATA")
    private String clientData;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "MOBILE_NO")
    private String mobileNo;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date")
    @CreatedDate
    private Date createdDate;

    public ClientDataEntity() {
    }

    @Column(name = "last_modified_by")
    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedBy
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @OneToMany(mappedBy="userServiceId")
    private Set<UserServicesEntity> userServicesEntities;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<UserServicesEntity> getUserServicesEntities() {
        return userServicesEntities;
    }

    public void setUserServicesEntities(Set<UserServicesEntity> userServicesEntities) {
        this.userServicesEntities = userServicesEntities;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientData() {
        return clientData;
    }

    public void setClientData(String clientData) {
        this.clientData = clientData;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public ClientDataEntity(ClientVO clientDataVO) {

        this.userName = clientDataVO.getUsername();
        this.dob = clientDataVO.getDob();
        this.email = clientDataVO.getEmail();
        this.mobileNo = clientDataVO.getMobileNo();
        this.phoneNo = clientDataVO.getPhoneNo();
    }

    public ClientDataEntity(Integer clientId) {
        this.clientId = clientId;
    }

}
