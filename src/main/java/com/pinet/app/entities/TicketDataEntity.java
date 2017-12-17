package com.pinet.app.entities;

import com.pinet.app.model.TicketDataVO;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.Date;

@Entity(name="ticket_data")
public class TicketDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TICKET_ID")
    private Integer ticketId;

    @Column(name="TICKET_TYPE")
    private String ticketType;

//    @Column(name="CLIENT_ID")
//    private String clientId;

    @Column(name="CONTACT_NO")
    private String contactNo;

    @Column(name="ASSIGNED_TO")
    private String assignedTo;

    @Column(name="NOTES")
    private String notes;

    @Column(name="ACTIVE")
    private Boolean active;

    @Column(name="FOLLOW_UP_BY")
    private String followUpBy;

    @Column(name="REVIEWED_BY")
    private String reviewedBy;

    @Column(name="SERVICE_ID")
    private Integer serviceId;

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

    @Column(name = "TIME_TO_COMPLETE")
    private Date timeToComplete;

    @Column(name="EMPLOYEE_EMAIL")
    private String employeeEmail;

    @Column(name="CLIENT_USERNAME")
    private String clientUsername;

    public TicketDataEntity() {
    }

    public TicketDataEntity(TicketDataVO ticketDataVO) {
        this.ticketType=ticketDataVO.getTicketType();
//        this.clientId=ticketDataVO.getClientId();
        this.contactNo=ticketDataVO.getContactNo();
        this.assignedTo=ticketDataVO.getAssignedTo();
        this.notes=ticketDataVO.getNotes();
        this.active=ticketDataVO.getActive();
        this.followUpBy=ticketDataVO.getFollowUpBy();
        this.reviewedBy=ticketDataVO.getReviewedBy();
        this.serviceId=ticketDataVO.getServiceId();
        this.timeToComplete=ticketDataVO.getTimeToComplete();
        this.employeeEmail=ticketDataVO.getEmail();
        this.clientUsername=ticketDataVO.getClientUsername();

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
