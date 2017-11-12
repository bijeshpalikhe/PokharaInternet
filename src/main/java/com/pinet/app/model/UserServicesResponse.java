package com.pinet.app.model;

import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.entities.UserServicesEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by bijesh on 10/29/2017.
 */
public class UserServicesResponse {

    private Integer userServiceId;
    private int clientID;
    private int serviceTypeEntity;
    private AddressVo installationAddress;
    private Boolean active;
    private String connectedArea;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public Integer getUserServiceId() {
        return userServiceId;
    }

    public void setUserServiceId(Integer userServiceId) {
        this.userServiceId = userServiceId;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getServiceTypeEntity() {
        return serviceTypeEntity;
    }

    public void setServiceTypeEntity(int serviceTypeEntity) {
        this.serviceTypeEntity = serviceTypeEntity;
    }

    public AddressVo getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(AddressVo installationAddress) {
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

    public UserServicesResponse(UserServicesEntity userServicesEntity) {
        this.userServiceId = userServicesEntity.getUserServiceId();
        this.clientID= userServicesEntity.getClientID().getClientId();
        this.serviceTypeEntity= userServicesEntity.getServiceTypeEntity().getId();
        this.active= userServicesEntity.getActive();
        this.connectedArea= userServicesEntity.getConnectedArea();
        this.createdBy= userServicesEntity.getCreatedBy();
        this.createdDate= userServicesEntity.getCreatedDate();
        this.lastModifiedBy= userServicesEntity.getLastModifiedBy();
        this.lastModifiedDate= userServicesEntity.getLastModifiedDate();
    }
}
