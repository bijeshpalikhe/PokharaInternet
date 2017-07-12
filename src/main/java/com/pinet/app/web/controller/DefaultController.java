package com.pinet.app.web.controller;

import com.pinet.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bijesh on 4/19/2017.
 */

@RestController
@RequestMapping(value = "")
public class DefaultController {
    @Autowired
    TestService service;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String savePhone() {
        String test = service.saveTestData();

        return  test;
    }
}
