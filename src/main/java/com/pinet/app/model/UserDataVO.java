package com.pinet.app.model;

import com.pinet.app.entities.UserDataEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by bijesh on 7/23/2017.
 */
public class UserDataVO {

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
    private String address;
    private String mobileNo;
    private String phoneNo;
    private String occupationType;
    private String serviceCode;
    private String subscriptionType;
    private String installationAddress;
    private Date lastModifiedDate;
    private String createdBy;
    private String lastModifiedBy;


    public UserDataVO(UserDataEntity userDataEntity) {
        this.name = userDataEntity.getName();
        this.username=userDataEntity.getUsername();
        this.address = userDataEntity.getAddress();
        this.gender = userDataEntity.getGender();
        this.dob = userDataEntity.getDob();
        this.nationality = userDataEntity.getNationality();
        this.citizenNo = userDataEntity.getCitizenNo();
        this.passportNo = userDataEntity.getPassportNo();
        this.fatherName = userDataEntity.getFatherName();
        this.email = userDataEntity.getEmail();
        this.address = userDataEntity.getAddress();
        this.mobileNo = userDataEntity.getMobileNo();
        this.phoneNo = userDataEntity.getPhoneNo();
        this.occupationType = userDataEntity.getOccupancyType();
        this.serviceCode = userDataEntity.getServiceCode();
        this.subscriptionType = userDataEntity.getSubscriptionType();
        this.installationAddress = userDataEntity.getInstallationAddress();
        this.lastModifiedDate = userDataEntity.getLastModifiedDate();
        this.createdBy=userDataEntity.getCreatedBy();
        this.lastModifiedBy=userDataEntity.getLastModifiedBy();
    }


//    public UserDataVO(String name, String username, Character gender, String dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address,
//                      String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress, Date lastModifiedDate,String createdBy) {
//        this.name = name;
//        this.username = username;
//        this.gender = gender;
//        this.dob = dob;
//        this.nationality = nationality;
//        this.citizenNo = citizenNo;
//        this.passportNo = passportNo;
//        this.fatherName = fatherName;
//        this.email = email;
//        this.address = address;
//        this.mobileNo = mobileNo;
//        this.phoneNo = phoneNo;
//        this.occupationType = occupationType;
//        this.serviceCode = serviceCode;
//        this.subscriptionType = subscriptionType;
//        this.installationAddress = installationAddress;
//        this.lastModifiedDate =lastModifiedDate;
//        this.createdBy=createdBy;
//    }

    public UserDataVO() {
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

    public String getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(String installationAddress) {
        this.installationAddress = installationAddress;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

}
