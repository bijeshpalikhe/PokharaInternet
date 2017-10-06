package com.pinet.app.entities;

import com.pinet.app.model.UserDataVO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ashmeet on 7/15/17.
 */
@Entity
@Table(name = "user_data")
public class UserDataEntity {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "user_name")
    private String username;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "dob")
    private String dob;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "citizen_no")
    private String citizenNo;

    @Column(name = "passport_no")
    private String passportNo;

    @Column(name = "Father_Name")
    private String fatherName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "occupation_type")
    private String occupationType;

    @Column(name = "service_codes")
    private String serviceCode;

    @Column(name = "subscription_types")
    private String subscriptionType;

    @Column(name = "installation_address")
    private String installationAddress;

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

    @Column(name="ROLES")
    private String roles;

    @Column(name="PASSWORD")
    private String password;


    public UserDataEntity(UserDataVO userDataVO) {
        this.name = userDataVO.getName();
        this.username = userDataVO.getUsername();
        this.gender = userDataVO.getGender();
        this.dob = userDataVO.getDob();
        this.nationality = userDataVO.getNationality();
        this.citizenNo = userDataVO.getCitizenNo();
        this.passportNo = userDataVO.getPassportNo();
        this.fatherName = userDataVO.getFatherName();
        this.email = userDataVO.getEmail();
        this.mobileNo = userDataVO.getMobileNo();
        this.phoneNo = userDataVO.getPhoneNo();
        this.occupationType = userDataVO.getOccupationType();
        this.serviceCode = userDataVO.getServiceCode();
        this.subscriptionType = userDataVO.getSubscriptionType();
        this.password=userDataVO.getPassword();
        this.roles=userDataVO.getRoles();
    }

    public UserDataEntity() {
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDataEntity(Integer userId, String name, String username, Character gender, String dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address, String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate,String password, String roles) {
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
}
