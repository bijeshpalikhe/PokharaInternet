package com.pinet.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by bijesh on 7/12/2017.
 */
@Service
public class TestService {

    @Autowired

    public String saveTestData(){

        return "Success";
    }
}
