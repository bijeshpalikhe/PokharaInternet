package com.pinet.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by bijesh on 7/23/2017.
 */
public class ClientVO {

    private String fname;
    private String mname;
    private String lname;

    private String username;
    private Character gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    private String nationality;
    private String citizenNo;
    private String passportNo;
    private String fatherName;
    private String email;
    private String mobileNo;
    private String phoneNo;
    private String occupationType;
    private Integer houseNo;
    private Integer wardNo;
    private String streetName;
    private String municipality;
    private String district;
    private String zone;


    public ClientVO() {
    }

    public ClientVO(ClientDataResponse clientDataResponse) {
        this.fname = clientDataResponse.getClientName().getFirstName();
        this.mname = clientDataResponse.getClientName().getMiddleName();
        this.lname = clientDataResponse.getClientName().getLastName();
        this.username = clientDataResponse.getUserName();

        this.gender = clientDataResponse.getClientData().getGender();
//        this.gender=clientDataResponse.getClientData().getGender();
        this.dob = clientDataResponse.getDob();
        this.nationality = clientDataResponse.getClientData().getNationality();
        this.citizenNo = clientDataResponse.getClientData().getCitizenNo();
        this.passportNo = clientDataResponse.getClientData().getPassportNo();
        this.fatherName = clientDataResponse.getClientData().getFatherName();
        this.email = clientDataResponse.getEmail();
        this.mobileNo = clientDataResponse.getMobileNo();
        this.phoneNo = clientDataResponse.getPhoneNo();
        this.occupationType = clientDataResponse.getClientData().getOccupationType();
        this.houseNo = clientDataResponse.getAddress().getHouseNo();
        this.wardNo = clientDataResponse.getAddress().getWardNo();
        this.municipality = clientDataResponse.getAddress().getMunicipality();
        this.district = clientDataResponse.getAddress().getDistrict();
        this.zone = clientDataResponse.getAddress().getZone();

    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public Integer getWardNo() {
        return wardNo;
    }

    public void setWardNo(Integer wardNo) {
        this.wardNo = wardNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private String country;


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

}
