package com.pinet.app.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pinet.app.config.JsonDateSerializer;
import com.pinet.app.entities.EmployeeInfoEntity;

import java.util.Date;

public class EmployeeInfoDataResponse {

    private Integer employeeId;
    private NameVO employeesName;
    private String phoneNo;
    private String email;
    private InfoVO info;
    private Date dob;
    private String idType;
    private String idNo;
    private String fileNo;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;


    public EmployeeInfoDataResponse() {
    }

    public EmployeeInfoDataResponse(Integer employeeId, NameVO employeesName, String phoneNo, String email,
                                    InfoVO info, Date dob, String idType, String idNo, String fileNo,
                                    String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        this.employeeId = employeeId;
        this.employeesName = employeesName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.info = info;
        this.dob = dob;
        this.idType = idType;
        this.idNo = idNo;
        this.fileNo = fileNo;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public EmployeeInfoDataResponse(EmployeeInfoEntity employeeInfoEntity){
        this.employeeId=employeeInfoEntity.getEmployeeId();
//        this.employeesName=employeeInfoEntity.getEmployeesName();
        this.phoneNo=employeeInfoEntity.getPhoneNo();
        this.email=employeeInfoEntity.getEmail();
//        this.info=employeeInfoEntity.getInfo();
        this.dob=employeeInfoEntity.getDob();
        this.idType=employeeInfoEntity.getIdType();
        this.idNo=employeeInfoEntity.getIdNo();
        this.fileNo=employeeInfoEntity.getFileNo();
        this.createdBy=employeeInfoEntity.getCreatedBy();
        this.createdDate=employeeInfoEntity.getCreatedDate();
        this.lastModifiedBy=employeeInfoEntity.getLastModifiedBy();
        this.lastModifiedDate=employeeInfoEntity.getLastModifiedDate();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public NameVO getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(NameVO employeesName) {
        this.employeesName = employeesName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InfoVO getInfo() {
        return info;
    }

    public void setInfo(InfoVO info) {
        this.info = info;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
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
}
