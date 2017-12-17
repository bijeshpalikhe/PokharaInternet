package com.pinet.app.model;

/**
 * Created by bijesh on 10/29/2017.
 */
public class UserServiceVo {

    private int clientId;
    private int serviceId;
    private AddressVo installationAddress;
    private Boolean active;
    private String connectedArea;

    public UserServiceVo() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
}
