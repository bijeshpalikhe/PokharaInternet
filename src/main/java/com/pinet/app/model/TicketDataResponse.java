package com.pinet.app.model;

import com.pinet.app.entities.TicketDataEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


public class TicketDataResponse {


    private Integer ticketId;
    private String ticketType;
//    private String clientId;
    private String contactNo;
    private String assignedTo;
    private String notes;
    private Boolean active;
    private String followUpBy;
    private String reviewedBy;
    private Integer serviceId;
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
    private String employeeEmail;
    private String clientUsername;

    private Date timeToComplete;

    public TicketDataResponse() {
    }

    public TicketDataResponse(TicketDataEntity ticketDataEntity){
        this.ticketId=ticketDataEntity.getTicketId();
        this.ticketType=ticketDataEntity.getTicketType();
//        this.clientId=ticketDataEntity.getClientId();
        this.contactNo=ticketDataEntity.getContactNo();
        this.assignedTo=ticketDataEntity.getAssignedTo();
        this.notes=ticketDataEntity.getNotes();
        this.active=ticketDataEntity.getActive();
        this.followUpBy=ticketDataEntity.getFollowUpBy();
        this.reviewedBy=ticketDataEntity.getReviewedBy();
        this.serviceId=ticketDataEntity.getServiceId();
        this.createdBy=ticketDataEntity.getCreatedBy();
        this.createdDate=ticketDataEntity.getCreatedDate();
        this.lastModifiedBy=ticketDataEntity.getLastModifiedBy();
        this.lastModifiedDate=ticketDataEntity.getLastModifiedDate();
        this.timeToComplete=ticketDataEntity.getTimeToComplete();
        this.employeeEmail=ticketDataEntity.getEmployeeEmail();
        this.clientUsername=ticketDataEntity.getClientUsername();
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

//    public String getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(String clientId) {
//        this.clientId = clientId;
//    }

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

    public Date getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Date timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }
}
