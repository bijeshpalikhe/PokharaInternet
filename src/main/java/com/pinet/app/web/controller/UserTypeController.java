package com.pinet.app.web.controller;

import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.ServiceReponse;
import com.pinet.app.model.UserDataResponse;
import com.pinet.app.model.UserDataVO;
import com.pinet.app.service.ServiceTypeService;
import com.pinet.app.service.UserTypeService;
import com.pinet.app.service.UserTypeServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by ashmeet on 7/19/17.
 */
@RestController
@RequestMapping(value = "/userdata")
public class UserTypeController {
    @Autowired
    UserTypeServiceInteface userTypeService;

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

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/deletebyid/{userId}")
    public ResponseEntity deleteUserById(@PathVariable("userId") Integer userId) {
        try {

            return ResponseEntity.ok(userTypeService.deleteUserById(userId));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/saveuser")
    public ResponseEntity saveUserDataNew(@RequestBody UserDataEntity userDataEntity) {
        try {
          //  System.out.println(userDataEntity.toString());

            return ResponseEntity.ok(userTypeService.saveUser(userDataEntity));


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/updateuser")
    public ResponseEntity updateUserData(@RequestBody UserDataEntity userDataEntity) {
        try {
            //  System.out.println(userDataEntity.toString());

            return ResponseEntity.ok(userTypeService.updateUserById(userDataEntity));


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
}