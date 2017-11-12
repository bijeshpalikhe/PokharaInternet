package com.pinet.app.entities;


import com.pinet.app.model.ClientVO;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

        /*
        *Created by bijesh on 7/17/2017.
        *Table to store user service  info
        * */


@Entity
@Table(name = "user_services")
public class UserServicesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_service_id")
    private Integer userServiceId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable=false)
    private ClientDataEntity clientID;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceTypeEntity serviceTypeEntity;

    @Column(name = "installation_address")
    private String installationAddress;

    @Column(name = "active")
    private Boolean active;


    @Column(name = "connected_area")
    private String connectedArea;

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

    public UserServicesEntity(Integer userServiceId, ClientDataEntity clientID, ServiceTypeEntity serviceTypeEntity, String installationAddress, Boolean active, String email, String connectedArea, String createdBy, Date createdDate, String lastModifiedBy, Date lastModifiedDate) {
        this.userServiceId = userServiceId;
        this.clientID = clientID;
        this.serviceTypeEntity = serviceTypeEntity;
        this.installationAddress = installationAddress;
        this.active = active;
        this.connectedArea = connectedArea;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
    }

    public UserServicesEntity() {

    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public Integer getUserServiceId() {
        return userServiceId;
    }

    public void setUserServiceId(Integer userServiceId) {
        this.userServiceId = userServiceId;
    }

    public ClientDataEntity getClientID() {
        return clientID;
    }

    public void setClientID(ClientDataEntity clientID) {
        this.clientID = clientID;
    }

    public ServiceTypeEntity getServiceTypeEntity() {
        return serviceTypeEntity;
    }

    public void setServiceTypeEntity(ServiceTypeEntity serviceTypeEntity) {
        this.serviceTypeEntity = serviceTypeEntity;
    }

    public String getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(String installationAddress) {
        this.installationAddress = installationAddress;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getConnectedArea() {
        return connectedArea;
    }

    public void setConnectedArea(String connectedArea) {
        this.connectedArea = connectedArea;
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
}
