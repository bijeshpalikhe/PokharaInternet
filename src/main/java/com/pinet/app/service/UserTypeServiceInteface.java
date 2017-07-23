package com.pinet.app.service;

import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.UserDataResponse;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * Created by ashmeet on 7/19/17.
 */
public interface UserTypeServiceInteface {
    UserDataResponse saveUser(String name, String username, Character gender, Date dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address, String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress);
    List<UserDataResponse> getUsers();
    UserDataResponse getUserByUserName(String username);
    UserDataResponse getUserById(Integer userId);
    UserDataResponse deleteUserById(Integer userId);
    UserDataResponse updateUserById(Integer userId);

}
