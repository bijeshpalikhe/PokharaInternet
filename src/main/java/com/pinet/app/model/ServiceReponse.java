package com.pinet.app.model;

/**
 * Created by bijesh on 7/17/2017.
 */
public class ServiceReponse {
    private int serviceId;
    private String serviceType;
    private String bandwidth;

    public ServiceReponse(int serviceId, String serviceType, String bandwidth) {
        this.serviceId = serviceId;
        this.serviceType = serviceType;
        this.bandwidth = bandwidth;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
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
}
