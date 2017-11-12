package com.pinet.app.model;

import java.util.Date;

public class EmployeeInfoVO {

    private NameVO employeesName;
    private String phoneNo;
    private String email;

    private Date dob;
    private String idType;
    private String idNo;
    private String fileNo;
    private InfoVO infoVO;

    public EmployeeInfoVO() {
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
