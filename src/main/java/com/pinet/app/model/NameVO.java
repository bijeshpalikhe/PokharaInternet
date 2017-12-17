package com.pinet.app.model;

/**
 * Created by bijesh on 10/11/2017.
 */
public class NameVO {

    private String firstName;
    private String middleName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NameVO() {
    }

    public NameVO(String firstName, String middleName, String lastName) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
