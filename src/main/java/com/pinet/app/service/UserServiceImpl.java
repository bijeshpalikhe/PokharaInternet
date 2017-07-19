package com.pinet.app.service;

import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ashmeet on 7/18/17.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserInterface{

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public String insertUser() {
        UserDataEntity userDataEntity=new UserDataEntity();
        userDataEntity.setName("Ashmeet");
        userDataEntity.setUsername("ashmeet4293");
        userDataEntity.setDob(new Date());
        userDataEntity.setGender('M');
        userDataEntity.setNationality("Nepali");
        userDataEntity.setCitizenNo("101-10101-101001");
        userDataEntity.setPassportNo("202-202-0222-22");
        userDataEntity.setFatherName("Pawan Tiwary");
        userDataEntity.setEmail("ashmeet4293@gmail.com");
        userDataEntity.setAddress("Pokhara");
        userDataEntity.setMobileNo("9846744037");
        userDataEntity.setPhoneNo("061-44037");
        userDataEntity.setOccupancyType("Trainer and Developer");
        userDataEntity.setServiceCode("001");
        userDataEntity.setSubscriptionType("Wireless");
        userDataEntity.setInstallationAddress("Pokhara-6 jarebar");

        userDataRepository.save(userDataEntity);
        return "Data Inserted successfully ";


    }

    @Override
    public String readSingleUser(int id) {
        UserDataEntity userDataEntity = new UserDataEntity();

        userDataEntity = userDataRepository.findOne(id);

        System.out.println(userDataEntity.getName());

        return (String)userDataEntity.getName();
    }

    @Override
    public List<UserDataEntity> findAllUsers() {
      List<UserDataEntity> users=new ArrayList<>();
      users=userDataRepository.findAll();
           // return UserDataRepository.;
        return users;
        }

    @Override
    public String updateUser(int id) {
        UserDataEntity userDataEntity=new UserDataEntity();

        userDataEntity = userDataRepository.findOne(id);

        userDataEntity.setName("Pawan Tiwary");
        userDataEntity.setUsername("ashmeet4293");
        userDataEntity.setDob(new Date());
        userDataEntity.setGender('M');
        userDataEntity.setNationality("Nepali");
        userDataEntity.setCitizenNo("101-10101-101001");
        userDataEntity.setPassportNo("202-202-0222-22");
        userDataEntity.setFatherName("Pawan Tiwary");
        userDataEntity.setEmail("ashmeet4293@gmail.com");
        userDataEntity.setAddress("Pokhara");
        userDataEntity.setMobileNo("9846744037");
        userDataEntity.setPhoneNo("061-44037");
        userDataEntity.setOccupancyType("Trainer and Developer");
        userDataEntity.setServiceCode("001");
        userDataEntity.setSubscriptionType("Wireless");
        userDataEntity.setInstallationAddress("Pokhara-6 jarebar");

        userDataRepository.save(userDataEntity);
        return "Data Updated successfully ";

    }

    @Override
    public String deleteUser(int id) {
        UserDataEntity userDataEntity=new UserDataEntity();

        userDataEntity = userDataRepository.findOne(id);

        userDataRepository.delete(userDataEntity);
        return userDataEntity.getName()+" Deleted Successfully";
    }


}