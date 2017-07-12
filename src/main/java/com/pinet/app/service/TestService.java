package com.pinet.app.service;

import com.pinet.app.dao.UserDetailEntity;
import com.pinet.app.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by bijesh on 7/12/2017.
 */
@Service
public class TestService {

    @Autowired
    UserDetailRepository userDetailRepository;

    public String saveTestData(){
        UserDetailEntity userDetailEntity = new UserDetailEntity();
        userDetailEntity.setName("test");
        userDetailEntity.setContactNo("123");
        userDetailEntity.setData("data");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        userDetailEntity.setDob(date);
        userDetailEntity.setEmail("email");
        userDetailEntity.setIdVerified(Boolean.TRUE);
        userDetailEntity.setIdVerifiedBy(1);


        userDetailRepository.save(userDetailEntity);

        return "Success";
    }
}
