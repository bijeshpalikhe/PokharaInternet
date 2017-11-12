package com.pinet.app.model;

import java.sql.Date;

/**
 * Created by bijesh on 7/23/2017.
 */
public class ClientDataVO {

    private Character gender;
    private String nationality;
    private String citizenNo;
    private String passportNo;
    private String fatherName;
    private String occupationType;

    public ClientDataVO() {
    }

    public ClientDataVO(Character gender, String nationality, String citizenNo, String passportNo, String fatherName, String occupationType) {
        this.gender = gender;
        this.nationality = nationality;
        this.citizenNo = citizenNo;
        this.passportNo = passportNo;
        this.fatherName = fatherName;
        this.occupationType = occupationType;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
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

    public String getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(String occupationType) {
        this.occupationType = occupationType;
    }
}
