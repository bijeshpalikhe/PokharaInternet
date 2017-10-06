package com.pinet.app.service;

import com.google.gson.Gson;
import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.AddressVo;
import com.pinet.app.model.UserDataResponse;
import com.pinet.app.model.UserDataVO;
import com.pinet.app.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ashmeet on 7/19/17.
 */
@Service
public class UserDataService {


    @Autowired
    UserDataRepository userDataRepository;

    public UserDataResponse saveUser(UserDataVO userDataVO, String employeeName) {

        UserDataEntity userDataEntity = new UserDataEntity(userDataVO);
        userDataEntity.setAddress(convertAdressToString(userDataVO.getAddress()));
        userDataEntity.setInstallationAddress(convertAdressToString(userDataVO.getInstallationAddress()));
        userDataEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        userDataEntity.setCreatedDate(utilDate);
        userDataEntity.setLastModifiedBy(employeeName);
        userDataEntity.setLastModifiedDate(utilDate);

        UserDataEntity savedUser = userDataRepository.save(userDataEntity);
        UserDataResponse response = new UserDataResponse(savedUser);
        response.setInstallationAddress(convertStringToAddress(userDataEntity.getInstallationAddress()));
        response.setAddress(convertStringToAddress(userDataEntity.getAddress()));
        return response;
    }

    public List<UserDataResponse> getAllUsers() {
        List<UserDataEntity> userDataEntityList = userDataRepository.findAll();
        List<UserDataResponse> userList = new ArrayList<>();

        for (UserDataEntity userDataEntity : userDataEntityList) {

            UserDataResponse response = new UserDataResponse(userDataEntity);
            userList.add(response);
            response.setInstallationAddress(convertStringToAddress(userDataEntity.getInstallationAddress()));
            response.setAddress(convertStringToAddress(userDataEntity.getAddress()));
        }
        return userList;
    }


    public UserDataResponse getUserById(Integer userId) {

        UserDataEntity userDataEntity = userDataRepository.findOne(userId);
        if (userDataEntity != null) {
            UserDataResponse response = new UserDataResponse(userDataEntity);
            response.setAddress(convertStringToAddress(userDataEntity.getAddress()));
            response.setInstallationAddress((convertStringToAddress(userDataEntity.getInstallationAddress())));
            return response;


        } else {
            return null;
        }


    }

    public String deleteUserById(Integer userId) {
        UserDataEntity user = userDataRepository.findOne(userId);
        if (user == null) {
            return null;
        } else {
            userDataRepository.delete(user);
            return "User successfully deleted";
        }
    }


    public UserDataResponse updateUserById(UserDataVO userDataVO, Integer userId, String employeeName) {
        UserDataEntity user = userDataRepository.findOne(userId);
        if (user != null) {
            user.setName(userDataVO.getName());
            user.setUsername(userDataVO.getUsername());
            user.setDob(userDataVO.getDob());
            user.setGender(userDataVO.getGender());
            user.setNationality(userDataVO.getNationality());
            user.setCitizenNo(userDataVO.getCitizenNo());
            user.setPassportNo(userDataVO.getPassportNo());
            user.setFatherName(userDataVO.getFatherName());
            user.setEmail(userDataVO.getEmail());
            user.setAddress(convertAdressToString(userDataVO.getAddress()));
            user.setMobileNo(userDataVO.getMobileNo());
            user.setPhoneNo(userDataVO.getPhoneNo());
            user.setOccupationType(userDataVO.getOccupationType());
            user.setServiceCode(userDataVO.getServiceCode());
            user.setSubscriptionType(userDataVO.getSubscriptionType());
            user.setPassword(userDataVO.getPassword());
            user.setRoles(userDataVO.getRoles());

            user.setInstallationAddress(convertAdressToString(userDataVO.getInstallationAddress()));
            java.util.Date utilDate = new java.util.Date();

            user.setLastModifiedDate(utilDate);
            String lastModifiedBY = user.getLastModifiedBy() + "," + employeeName;
            user.setLastModifiedBy(lastModifiedBY);

            UserDataEntity savedUser = userDataRepository.save(user);
            UserDataResponse response = new UserDataResponse(savedUser);
            response.setInstallationAddress(convertStringToAddress(savedUser.getInstallationAddress()));
            response.setAddress(convertStringToAddress(savedUser.getAddress()));
            return response;
        } else {
            return null;
        }


    }

    public String convertAdressToString(AddressVo addressVo) {
        Gson gson = new Gson();
        String json = gson.toJson(addressVo);
        return json;

    }

    public AddressVo convertStringToAddress(String jsonString) {
        Gson gson = new Gson();
        AddressVo addressVo = gson.fromJson(jsonString, AddressVo.class);
        return addressVo;

    }


}
