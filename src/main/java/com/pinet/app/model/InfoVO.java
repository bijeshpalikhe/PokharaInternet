package com.pinet.app.model;

public class InfoVO {
    private String employeeAddress;
    private String employmentDate;
    private String employeeContactName;
    private Boolean employeeRelation;
    private String emergencyPhone;

    public InfoVO(){

    }

    public InfoVO(String employeeAddress, String employmentDate, String employeeContactName, Boolean employeeRelation, String emergencyPhone) {
        this.employeeAddress = employeeAddress;
        this.employmentDate = employmentDate;
        this.employeeContactName = employeeContactName;
        this.employeeRelation = employeeRelation;
        this.emergencyPhone = emergencyPhone;
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

    public String getEmployeeContactName() {
        return employeeContactName;
    }

    public void setEmployeeContactName(String employeeContactName) {
        this.employeeContactName = employeeContactName;
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
