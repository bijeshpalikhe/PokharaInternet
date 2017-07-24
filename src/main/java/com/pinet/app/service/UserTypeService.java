package com.pinet.app.service;

import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.UserDataResponse;
import com.pinet.app.model.UserDataVO;
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
public class UserTypeService {


    @Autowired
    UserDataRepository userDataRepository;


    public UserDataResponse saveUser(UserDataVO userDataVO) {
        UserDataEntity userDataEntity = new UserDataEntity(userDataVO);

        UserDataEntity savedUser = userDataRepository.save(userDataEntity);
        UserDataResponse response = new UserDataResponse(savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
    }

    public List<UserDataResponse> getAllUsers() {
        List<UserDataEntity> userDataEntityList = userDataRepository.findAll();
        List<UserDataResponse> userList = new ArrayList<>();

        for (UserDataEntity userDataEntity : userDataEntityList) {
            UserDataResponse response = new UserDataResponse(userDataEntity.getName(), userDataEntity.getUsername(), userDataEntity.getGender(), userDataEntity.getDob(), userDataEntity.getNationality(), userDataEntity.getCitizenNo(), userDataEntity.getPassportNo(), userDataEntity.getFatherName(), userDataEntity.getEmail(), userDataEntity.getAddress(), userDataEntity.getMobileNo(), userDataEntity.getPhoneNo(), userDataEntity.getOccupancyType(), userDataEntity.getServiceCode(), userDataEntity.getSubscriptionType(), userDataEntity.getInstallationAddress());

            userList.add(response);
        }
        return userList;
    }


    public UserDataResponse getUserById(Integer userId) {
<<<<<<< HEAD
        UserDataEntity userDataEntity=new UserDataEntity();


        userDataEntity = userDataRepository.findOne(userId);

=======
        UserDataEntity userDataEntity = userDataRepository.findOne(userId);
        UserDataResponse response = new UserDataResponse(userDataEntity.getUserId(), userDataEntity.getName(), userDataEntity.getUsername(), userDataEntity.getGender(), userDataEntity.getDob(), userDataEntity.getNationality(), userDataEntity.getCitizenNo(), userDataEntity.getPassportNo(), userDataEntity.getFatherName(), userDataEntity.getEmail(), userDataEntity.getAddress(), userDataEntity.getMobileNo(), userDataEntity.getPhoneNo(), userDataEntity.getOccupancyType(), userDataEntity.getServiceCode(), userDataEntity.getSubscriptionType(), userDataEntity.getInstallationAddress());
>>>>>>> 1e94e5c0bcf06c508a3bdb0b6cd8c0520df43fcf

        return null;
    }

    public String deleteUserById(Integer userId) {
        UserDataEntity user = userDataRepository.findOne(userId);
        if (user == null) {
            return "User not found";
        } else {
            userDataRepository.delete(user);
            return "User successfully deleted";
        }
    }

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

        UserDataEntity savedUser = userDataRepository.save(user);
        UserDataResponse response = new UserDataResponse(savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
    }


}
