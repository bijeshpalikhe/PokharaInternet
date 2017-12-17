package com.pinet.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TicketDataVO {

    //   private String clientId;
    private String ticketType;
    private String contactNo;
    private String assignedTo;
    private String notes;
    private Boolean active;
    private String followUpBy;
    private String reviewedBy;
    private Integer serviceId;
    private Integer employeeId;
//    @DateTimeFormat(pattern = "dd-MM-YYYY HH:MM:SS")
    private Date timeToComplete;
    private String email;
    private String clientUsername;


    public TicketDataVO() {
    }

    public TicketDataVO(TicketDataResponse ticketDataResponse) {

    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFollowUpBy() {
        return followUpBy;
    }

    public void setFollowUpBy(String followUpBy) {
        this.followUpBy = followUpBy;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }


    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }
}
