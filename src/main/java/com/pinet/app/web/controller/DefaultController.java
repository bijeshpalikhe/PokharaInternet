package com.pinet.app.web.controller;


import com.pinet.app.service.*;
import com.pinet.app.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bijesh on 4/19/2017.
 */

@RestController
@RequestMapping(value = "")
public class DefaultController {

    @RequestMapping()
    public String testMessage() {
        return "Greetings from Pinet";
    }


    @RequestMapping(value = "/test")
    public String getUsers() {
        return "Test";
    }
}
