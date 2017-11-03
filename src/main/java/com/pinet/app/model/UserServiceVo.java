package com.pinet.app.model;

/**
 * Created by bijesh on 10/29/2017.
 */
public class UserServiceVo {
    private int clientId;
    private int serviceId;
    private AddressVo installationAddress;

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

}
