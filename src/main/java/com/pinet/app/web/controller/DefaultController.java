package com.pinet.app.web.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Secured(value="ROLE_ADMIN")
    @RequestMapping("/test")
    public String showAccess(){
        return "Test Authroized ";
    }
    @Secured(value="ROLE_USER")
    @RequestMapping("/user")
    public String showAccessToUser(){
        return "User Authroized ";
    }
//    @Secured(value="ROLE_ADMIN")
    @RequestMapping("/admin")
    public String showAdminAccess(){
        return "Admin Authroized ";
    }
}
