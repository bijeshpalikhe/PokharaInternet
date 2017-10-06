package com.pinet.app.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pinet.app.config.JsonDateSerializer;
import com.pinet.app.entities.UserDataEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.datetime.DateFormatter;

import javax.persistence.Column;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ashmeet on 7/19/17.
 */
public class UserDataResponse {

    private Integer userId;
    private String name;
    private String username;
    private Character gender;
    private String dob;
    private String nationality;
    private String citizenNo;
    private String passportNo;
    private String fatherName;
    private String email;
    private AddressVo address;
    private String mobileNo;
    private String phoneNo;
    private String occupationType;
    private String serviceCode;
    private String subscriptionType;
    private AddressVo installationAddress;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private String password;
    private String roles;

    public UserDataResponse(Integer userId, String name, String username, Character gender, String dob,
                            String nationality, String citizenNo, String passportNo, String fatherName,
                            String email, AddressVo address, String mobileNo, String phoneNo,
                            String occupationType, String serviceCode, String subscriptionType,
                            AddressVo installationAddress, String createdBy, Date createdDate,
                            String lastModifiedBy,Date lastModifiedDate, String password, String roles) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.citizenNo = citizenNo;
        this.passportNo = passportNo;
        this.fatherName = fatherName;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.phoneNo = phoneNo;
        this.occupationType = occupationType;
        this.serviceCode = serviceCode;
        this.subscriptionType = subscriptionType;
        this.installationAddress = installationAddress;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.password=password;
        this.roles=roles;
    }



    public UserDataResponse(UserDataEntity userDataEntity) {
        this.userId = userDataEntity.getUserId();
        this.name = userDataEntity.getName();
        this.username = userDataEntity.getUsername();
        this.gender = userDataEntity.getGender();
        this.dob = userDataEntity.getDob();
        this.nationality = userDataEntity.getNationality();
        this.citizenNo = userDataEntity.getCitizenNo();
        this.passportNo = userDataEntity.getPassportNo();
        this.fatherName = userDataEntity.getFatherName();
        this.email = userDataEntity.getEmail();
        this.mobileNo = userDataEntity.getMobileNo();
        this.phoneNo = userDataEntity.getPhoneNo();
        this.occupationType = userDataEntity.getOccupationType();
        this.serviceCode = userDataEntity.getServiceCode();
        this.subscriptionType = userDataEntity.getSubscriptionType();
        this.createdDate = userDataEntity.getCreatedDate();
        this.createdBy = userDataEntity.getCreatedBy();
        this.lastModifiedBy = userDataEntity.getLastModifiedBy();
        this.lastModifiedDate = userDataEntity.getLastModifiedDate();
        this.password=userDataEntity.getPassword();
        this.roles=userDataEntity.getRoles();
    }

    public UserDataResponse() {

    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCitizenNo() {
        return citizenNo;
    }

    public void setCitizenNo(String citizenNo) {
        this.citizenNo = citizenNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressVo getAddress() {
        return address;
    }

    public void setAddress(AddressVo address) {
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

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public AddressVo getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(AddressVo installationAddress) {
        this.installationAddress = installationAddress;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
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

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
