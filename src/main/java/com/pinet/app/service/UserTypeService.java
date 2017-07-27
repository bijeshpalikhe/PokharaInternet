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
        UserDataResponse response = new UserDataResponse(savedUser.getUserId(),savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
    }

    public List<UserDataResponse> getAllUsers() {
        List<UserDataEntity> userDataEntityList = userDataRepository.findAll();
        List<UserDataResponse> userList = new ArrayList<>();

        for (UserDataEntity userDataEntity : userDataEntityList) {
            UserDataResponse response = new UserDataResponse(userDataEntity.getUserId(), userDataEntity.getName(), userDataEntity.getUsername(), userDataEntity.getGender(), userDataEntity.getDob(), userDataEntity.getNationality(), userDataEntity.getCitizenNo(), userDataEntity.getPassportNo(), userDataEntity.getFatherName(), userDataEntity.getEmail(), userDataEntity.getAddress(), userDataEntity.getMobileNo(), userDataEntity.getPhoneNo(), userDataEntity.getOccupancyType(), userDataEntity.getServiceCode(), userDataEntity.getSubscriptionType(), userDataEntity.getInstallationAddress());

            userList.add(response);
        }
        return userList;
    }


<<<<<<< HEAD
=======
    public UserDataResponse getUserById(Integer userId) {

        UserDataEntity  userDataEntity = userDataRepository.findOne(userId);

        UserDataResponse response = new UserDataResponse(userDataEntity.getUserId(), userDataEntity.getName(), userDataEntity.getUsername(), userDataEntity.getGender(), userDataEntity.getDob(), userDataEntity.getNationality(), userDataEntity.getCitizenNo(), userDataEntity.getPassportNo(), userDataEntity.getFatherName(), userDataEntity.getEmail(), userDataEntity.getAddress(), userDataEntity.getMobileNo(), userDataEntity.getPhoneNo(), userDataEntity.getOccupancyType(), userDataEntity.getServiceCode(), userDataEntity.getSubscriptionType(), userDataEntity.getInstallationAddress());

        return response;
    }

>>>>>>> a792fd2ee53988571a8174afa0d12ccd88400e68
    public String deleteUserById(Integer userId) {
        UserDataEntity user = userDataRepository.findOne(userId);
        if (user == null) {
            return "User not found";
        } else {
            userDataRepository.delete(user);
            return "User successfully deleted";
        }
    }
    public UserDataEntity readUserById(Integer userId){
        UserDataEntity user = userDataRepository.findOne(userId);
        return user;

    }

<<<<<<< HEAD
    public String updateUserById(Integer  userId) {
        UserDataEntity user = userDataRepository.findOne(userId);
        UserDataVO userDataVO=new UserDataVO(user);

        UserDataEntity savedUser = userDataRepository.save(user);
        return "User updated successfully";
=======
    public UserDataResponse updateUserById(UserDataVO userDataVO,Integer userId) {
        UserDataEntity  user = userDataRepository.findOne(userId);

        user.setName(userDataVO.getName());
        user.setUsername(userDataVO.getUsername());
        user.setDob(userDataVO.getDob());
        user.setGender(userDataVO.getGender());
        user.setNationality(userDataVO.getNationality());
        user.setCitizenNo(userDataVO.getCitizenNo());
        user.setPassportNo(userDataVO.getPassportNo());
        user.setFatherName(userDataVO.getFatherName());
        user.setEmail(userDataVO.getEmail());
        user.setAddress(userDataVO.getAddress());
        user.setMobileNo(userDataVO.getMobileNo());
        user.setPhoneNo(userDataVO.getPhoneNo());
        user.setOccupancyType(userDataVO.getOccupationType());
        user.setServiceCode(userDataVO.getServiceCode());
        user.setSubscriptionType(userDataVO.getSubscriptionType());
        user.setInstallationAddress(userDataVO.getInstallationAddress());

        UserDataEntity savedUser = userDataRepository.save(user);
        UserDataResponse response = new UserDataResponse(savedUser.getUserId(),savedUser.getName(), savedUser.getUsername(), savedUser.getGender(), savedUser.getDob(), savedUser.getNationality(), savedUser.getCitizenNo(), savedUser.getPassportNo(), savedUser.getFatherName(), savedUser.getEmail(), savedUser.getAddress(), savedUser.getMobileNo(), savedUser.getPhoneNo(), savedUser.getOccupancyType(), savedUser.getServiceCode(), savedUser.getSubscriptionType(), savedUser.getInstallationAddress());
        return response;
>>>>>>> a792fd2ee53988571a8174afa0d12ccd88400e68
    }


}
