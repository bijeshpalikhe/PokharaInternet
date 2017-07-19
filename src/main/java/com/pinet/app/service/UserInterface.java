package com.pinet.app.service;

import com.pinet.app.dao.UserDataEntity;
import com.pinet.app.repository.UserDataRepository;

import java.util.List;

/**
 * Created by ashmeet on 7/18/17.
 */
public interface UserInterface {
    public String insertUser();
    public String  readSingleUser(int id);
    public List<UserDataEntity> findAllUsers();
    public String updateUser(int id);
    public String deleteUser(int id);
//    public boolean isUserExist(UserDataEntity user);
}
