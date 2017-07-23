package com.pinet.app.model;

import javax.persistence.Entity;

/**
 * Created by bijesh on 7/23/2017.
 */
public class UserDataVO {
    private Integer userId;
    private String name;
    private String username;

    public UserDataVO() {
    }

    public UserDataVO(Integer userId, String name, String username) {

        this.userId = userId;
        this.name = name;
        this.username = username;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
