package com.pinet.app.model;

import com.pinet.app.entities.ServiceTypeEntity; /**
 * Created by bijesh on 7/17/2017.
 */
public class ServiceResponse {
    private Integer serviceId;
    private String serviceType;
    private String bandwidth;
    private String notes;

    public ServiceResponse(Integer serviceId, String serviceType, String bandwidth, String notes) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.bandwidth = bandwidth;
        this.notes = notes;
    }

    public ServiceResponse(ServiceTypeEntity serviceTypeEntity) {
        this.serviceId=serviceTypeEntity.getId();
        this.serviceType=serviceTypeEntity.getService();
        this.bandwidth=serviceTypeEntity.getBandwidth();
        this.notes=serviceTypeEntity.getNotes();
    }

    public ServiceResponse() {

    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
