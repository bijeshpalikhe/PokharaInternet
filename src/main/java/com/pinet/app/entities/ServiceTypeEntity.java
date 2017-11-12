package com.pinet.app.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by bijesh on 7/17/2017.
 */
@Entity
@Table(name = "service_type")
public class ServiceTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service")
    private String service; //immutable\

    @Column(name = "bandwidth")
    private String bandwidth;

    public ServiceTypeEntity(Integer id, String service, String bandwidth) {
        this.id = id;
        this.service = service;
        this.bandwidth = bandwidth;
    }

    public ServiceTypeEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public ServiceTypeEntity(Integer id) {
        this.id = id;
    }
}
