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
    UserDataResponse saveUser(UserDataEntity userDataEntity);
    List<UserDataResponse> getUsers();
    UserDataResponse getUserByUserName(String username);
    UserDataResponse getUserById(Integer userId);
    UserDataResponse deleteUserById(Integer userId);
    UserDataResponse updateUserById(UserDataEntity userDataEntity);

}
