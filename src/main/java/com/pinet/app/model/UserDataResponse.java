package com.pinet.app.model;

import java.util.Date;

/**
 * Created by ashmeet on 7/19/17.
 */
public class UserDataResponse {

   private Integer userId;
    private String name;
    private String username;
    private Character gender;
    private Date dob;
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


    public UserDataResponse(){

    }
    public UserDataResponse(Integer userId, String name, String username, Character gender, Date dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address, String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress) {
        this.userId=userId;
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
    }
    public UserDataResponse(String name, String username, Character gender, Date dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address, String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress) {
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public String getOccupancyType() {
        return occupationType;
    }

    public void setOccupancyType(String occupancyType) {
        this.occupationType = occupancyType;
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


}
