package com.pinet.app.model;

public class InfoVO {

    private String employeeAddress;
    private String employmentDate;
    private String employeeContactNumber;
    private Boolean employeeRelation;
    private String emergencyPhone;

    public InfoVO(String employeeAddress, String employmentDate, String employeeContactNumber, Boolean employeeRelation, String emergencyPhone) {
        this.employeeAddress = employeeAddress;
        this.employmentDate = employmentDate;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeRelation = employeeRelation;
        this.emergencyPhone = emergencyPhone;
    }

    public InfoVO() {
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public Boolean getEmployeeRelation() {
        return employeeRelation;
    }

    public void setEmployeeRelation(Boolean employeeRelation) {
        this.employeeRelation = employeeRelation;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
}