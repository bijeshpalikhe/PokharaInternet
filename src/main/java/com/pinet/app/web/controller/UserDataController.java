package com.pinet.app.web.controller;

import com.pinet.app.model.UserDataResponse;
import com.pinet.app.model.UserDataVO;
import com.pinet.app.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ashmeet on 7/19/17.
 */
@RestController
@RequestMapping(value = "/userdata")
public class UserDataController {
    @Autowired
    UserDataService userDataService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/users")
    public ResponseEntity getUsers() {
        try {

            return ResponseEntity.ok(userDataService.getAllUsers());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer userId) {
        try {
            UserDataResponse response = userDataService.getUserById(userId);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity deleteUserById(@PathVariable("userId") Integer userId) {
        try {

            String response = userDataService.deleteUserById(userId);

            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/user")
    public ResponseEntity saveUserData(@RequestBody UserDataVO userDataVO, @RequestParam("employeeName") String employeeName) {
        try {

            return ResponseEntity.ok(userDataService.saveUser(userDataVO, employeeName));


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity updateUserData(@RequestBody UserDataVO userDataVO, @PathVariable("userId") Integer userId, @RequestParam("employeeName") String employeeName) {
        try {

            UserDataResponse response = userDataService.updateUserById(userDataVO, userId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
}