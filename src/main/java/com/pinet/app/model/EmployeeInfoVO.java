package com.pinet.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeInfoVO {

    private NameVO employeesName;
    private String phoneNo;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private String idType;
    private String idNo;
    private String fileNo;
    private InfoVO infoVO;

    public EmployeeInfoVO() {
    }
    public EmployeeInfoVO(EmployeeInfoResponse employeeInfoResponse){
        this.employeesName=employeeInfoResponse.getEmployeesName();
        this.phoneNo=employeeInfoResponse.getPhoneNo();
        this.dob=employeeInfoResponse.getDob();
        this.idType=employeeInfoResponse.getIdType();
        this.idNo=employeeInfoResponse.getIdNo();
        this.fileNo=employeeInfoResponse.getFileNo();
        this.infoVO=employeeInfoResponse.getInfo();

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

    public InfoVO getInfoVO() {
        return infoVO;
    }

    public void setInfoVO(InfoVO infoVO) {
        this.infoVO = infoVO;
    }
}
