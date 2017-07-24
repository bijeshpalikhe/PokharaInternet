package com.pinet.app.service;

import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.UserDataResponse;
import com.pinet.app.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ashmeet on 7/19/17.
 */
@Service
public class UserTypeService implements UserTypeServiceInteface {


    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDataResponse saveUser(UserDataEntity userDataEntity){

//        userDataEntity.setName(name);
//        userDataEntity.setUsername(username);
//        userDataEntity.setDob(new Date());
//        userDataEntity.setGender(gender);
//        userDataEntity.setNationality(nationality);
//        userDataEntity.setCitizenNo(citizenNo);
//        userDataEntity.setPassportNo(passportNo);
//        userDataEntity.setFatherName(fatherName);
//        userDataEntity.setEmail(email);
//        userDataEntity.setAddress(address);
//        userDataEntity.setMobileNo(mobileNo);
//        userDataEntity.setPhoneNo(phoneNo);
//        userDataEntity.setOccupancyType(occupationType);
//        userDataEntity.setServiceCode(serviceCode);
//        userDataEntity.setSubscriptionType(subscriptionType);
//        userDataEntity.setInstallationAddress(installationAddress);

        UserDataEntity savedUser=userDataRepository.save(userDataEntity);
        UserDataResponse response = new UserDataResponse(savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
    }

    @Override
    public List<UserDataResponse> getUsers() {
        List<UserDataEntity> userDataEntityList = userDataRepository.findAll();
        List<UserDataResponse> userList = new ArrayList<>();

        for (UserDataEntity userDataEntity : userDataEntityList) {
            UserDataResponse response = new UserDataResponse(userDataEntity.getName(), userDataEntity.getUsername(), userDataEntity.getGender(), userDataEntity.getDob(), userDataEntity.getNationality(), userDataEntity.getCitizenNo(), userDataEntity.getPassportNo(), userDataEntity.getFatherName(), userDataEntity.getEmail(), userDataEntity.getAddress(), userDataEntity.getMobileNo(), userDataEntity.getPhoneNo(), userDataEntity.getOccupancyType(), userDataEntity.getServiceCode(), userDataEntity.getSubscriptionType(), userDataEntity.getInstallationAddress());

            userList.add(response);
        }
        return userList;
    }

    @Override
    public UserDataResponse getUserByUserName(String username) {
        return null;
    }

    @Override
    public UserDataResponse getUserById(Integer userId) {
        UserDataEntity userDataEntity=new UserDataEntity();


        userDataEntity = userDataRepository.findOne(userId);

        UserDataResponse response = new UserDataResponse(savedUser.getUserId(), savedUser.getUserId(), savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());

        return response;
    }

    @Override
    public UserDataResponse deleteUserById(Integer userId) {
        UserDataEntity user=new UserDataEntity();


        user = userDataRepository.findOne(userId);

//        UserDataEntity savedUser=userDataRepository.save(userDataEntity);

        userDataRepository.delete(user);

        System.out.println("UserDeleted");

        UserDataResponse response = new UserDataResponse(user.getName(), user.getUsername(), user.getGender(), user.getDob(), user.getNationality(), user.getCitizenNo(), user.getPassportNo(), user.getFatherName(), user.getEmail(), user.getAddress(), user.getMobileNo(), user.getPhoneNo(), user.getOccupancyType(), user.getServiceCode(), user.getSubscriptionType(), user.getInstallationAddress());
//
        return response;
    }

    @Override
    public UserDataResponse updateUserById(UserDataEntity userDataEntity) {
        UserDataEntity user = new UserDataEntity();
        user = userDataRepository.findOne(userDataEntity.getUserId());

        user.setName(userDataEntity.getName());
        user.setUsername(userDataEntity.getUsername());
        user.setDob(userDataEntity.getDob());
        user.setGender(userDataEntity.getGender());
        user.setNationality(userDataEntity.getNationality());
        user.setCitizenNo(userDataEntity.getCitizenNo());
        user.setPassportNo(userDataEntity.getPassportNo());
        user.setFatherName(userDataEntity.getFatherName());
        user.setEmail(userDataEntity.getEmail());
        user.setAddress(userDataEntity.getAddress());
        user.setMobileNo(userDataEntity.getMobileNo());
        user.setPhoneNo(userDataEntity.getPhoneNo());
        user.setOccupancyType(userDataEntity.getOccupancyType());
        user.setServiceCode(userDataEntity.getServiceCode());
        user.setSubscriptionType(userDataEntity.getSubscriptionType());
        user.setInstallationAddress(userDataEntity.getInstallationAddress());

        UserDataEntity savedUser=userDataRepository.save(user);
        UserDataResponse response = new UserDataResponse(savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
    }


}
