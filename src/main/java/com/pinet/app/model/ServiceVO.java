package com.pinet.app.model;

public class ServiceVO {
    private Integer id;
    private String serviceType;
    private String bandwidth;
    private String notes;

    public ServiceVO() {
    }

    public ServiceVO(Integer id, String serviceType, String bandwidth, String notes) {
        this.id = id;
        this.serviceType = serviceType;
        this.bandwidth = bandwidth;
        this.notes=notes;
    }

    public ServiceVO(ServiceResponse serviceResponse) {
        this.id=serviceResponse.getServiceId();
        this.serviceType=serviceResponse.getServiceType();
        this.bandwidth=serviceResponse.getBandwidth();
        this.notes=serviceResponse.getNotes();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
