package com.pinet.app.service;

import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by bijesh on 7/12/2017.
 */
@Service
public class TestService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public String saveTestData() {
        ServiceTypeEntity test = new ServiceTypeEntity(1, "test", "Test");
        serviceTypeRepository.save(test);
        return "Success";
    }
}
