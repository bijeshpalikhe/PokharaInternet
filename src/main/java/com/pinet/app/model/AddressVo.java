package com.pinet.app.model;

/**
 * Created by bijesh on 8/1/2017.
 */
public class AddressVo {
    private int houseNo;
    private int wardNO;
    private String tole;
    private String municipality;
    private String district;
    private String zone;
    private String country;

    public AddressVo(int houseNo, int wardNO, String tole, String municipality, String district, String zone, String country) {
        this.houseNo = houseNo;
        this.wardNO = wardNO;
        this.tole = tole;
        this.municipality = municipality;
        this.district = district;
        this.zone = zone;
        this.country = country;
    }

    public AddressVo() {

    }

    public int getHouseNo() {

        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getWardNO() {
        return wardNO;
    }

    public void setWardNO(int wardNO) {
        this.wardNO = wardNO;
    }

    public String getTole() {
        return tole;
    }

    public void setTole(String tole) {
        this.tole = tole;
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
}
