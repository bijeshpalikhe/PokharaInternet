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
    //(String name, String username, Character gender, Date dob, String nationality, String citizenNo, String passportNo, String fatherName, String email, String address, String mobileNo, String phoneNo, String occupationType, String serviceCode, String subscriptionType, String installationAddress)

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "insert/{name}/{userName}/{gender}/{dob}/{nationality}/{citizenNo}/{passportNo}/" +
            "{fatherName}/{email}/{address}/{mobileNo}/{phoneNo}/{subscriptionType}/{installationAddress}")
    public ResponseEntity saveUserData(@PathVariable("name") String name, @PathVariable("userName") String userName, @PathVariable("gender") Character gender,
                                       @PathVariable("dob") Date dob, @PathVariable("nationality") String nationality, @PathVariable("citizenNo") String citizenNo,
                                       @PathVariable("passportNo") String passportNo, @PathVariable("fatherName") String fatherName, @PathVariable("email") String email,
                                       @PathVariable("address") String address, @PathVariable("mobileNo") String mobileNo, @PathVariable("phoneNo") String phoneNo,
                                       @PathVariable("occupationType") String occupationType, @PathVariable("serviceCode") String serviceCode,
                                       @PathVariable("subscriptionType") String subscriptionType, @PathVariable("installationAddress") String installationAddress) {
        try {
            UserDataResponse response = userTypeService.saveUser(name, userName, gender, dob, nationality, citizenNo, passportNo, fatherName, email, address, mobileNo, phoneNo, occupationType, serviceCode, subscriptionType, installationAddress);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/saveuser")
    public ResponseEntity saveUserDataNew(@RequestBody UserDataVO userDataVO) {
        try {
            return ResponseEntity.ok(userDataVO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
}