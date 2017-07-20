package com.pinet.app.web.controller;

import com.pinet.app.service.ServiceTypeService;
import com.pinet.app.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ashmeet on 7/19/17.
 */
@RestController
@RequestMapping(value = "/userdata")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/getusers")
    public ResponseEntity getUsers() {
        try {

            return ResponseEntity.ok(userTypeService.getUsers());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/searchbyid/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer userId) {
        try {

            return ResponseEntity.ok(userTypeService.getUserById(userId));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }
}
