package com.pinet.app.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pinet.app.config.JsonDateSerializer;
import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ashmeet on 7/19/17.
 */
public class ClientDataResponse {

    private Integer clientId;
    private String userName;
    private NameVO clientName;
    private ClientDataVO clientData;
    private Date dob;
    private String email;
    private AddressVo address;
    private String mobileNo;
    private String phoneNo;
    private String createdBy;
    private java.sql.Date createdDate;
    private String lastModifiedBy;
    private java.sql.Date lastModifiedDate;

    public ClientDataResponse() {
    }

    public ClientDataResponse(ClientDataEntity clientDataEntity) {
        this.clientId = clientDataEntity.getClientId();
        this.userName = clientDataEntity.getUserName();
        this.dob = clientDataEntity.getDob();
        this.email = clientDataEntity.getEmail();
        this.mobileNo = clientDataEntity.getMobileNo();
        this.phoneNo = clientDataEntity.getPhoneNo();
        this.createdBy = clientDataEntity.getCreatedBy();
        this.createdDate = clientDataEntity.getCreatedDate();
        this.lastModifiedBy = clientDataEntity.getLastModifiedBy();
        this.lastModifiedDate =  clientDataEntity.getLastModifiedDate();
    }


//    public String getClientName() {
//        return clientName.getFirstName()+" "+clientName.getMiddleName()+" "+clientName.getLastName();
//    }

    public NameVO getClientName() {
        return clientName;
    }

    public void setClientName(NameVO clientName) {
        this.clientName = clientName;
    }

    public ClientDataVO getClientData() {
        return clientData;
    }

    public void setClientData(ClientDataVO clientData) {
        this.clientData = clientData;
    }

    public AddressVo getAddress() {
        return address;
    }
//    public String getAddress() {
//        String address=this.address.getMunicipality()+"-"+this.address.getWaardNo()+", "+this.address.getStreetName();
//        return address;
//    }
    public void setAddress(AddressVo address) {
        this.address = address;
    }



    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreatedDate() {
        return createdDate;
    }



    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setCreatedDate(java.sql.Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(java.sql.Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
