package com.pinet.app.model;

/**
 * Created by bijesh on 10/28/2017.
 */
public class AddressVo {

    private Integer houseNo;
    private Integer wardNo;
    private String streetName;
    private String municipality;
    private String district;
    private String zone;
    private String country;

    public AddressVo() {
    }

    public Integer getHouseNo() {

        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public Integer getWardNo() {
        return wardNo;
    }

    public void setWrdNo(Integer wardNo) {
        this.wardNo = wardNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressVo(Integer houseNo, Integer wardNo, String streetName, String municipality, String district, String zone, String country) {

        this.houseNo = houseNo;
        this.wardNo = wardNo;
        this.streetName = streetName;
        this.municipality = municipality;
        this.district = district;
        this.zone = zone;
        this.country = country;
    }
}
