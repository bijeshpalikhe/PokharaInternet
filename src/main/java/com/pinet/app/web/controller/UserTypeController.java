package com.pinet.app.web.controller;

import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.UserDataVO;
import com.pinet.app.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ashmeet on 7/19/17.
 */
@RestController
@RequestMapping(value = "/userdata")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/users")
    public ResponseEntity getUsers() {
        try {

            return ResponseEntity.ok(userTypeService.getAllUsers());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer userId) {
        try {

            return ResponseEntity.ok(userTypeService.readUserById(userId));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity deleteUserById(@PathVariable("userId") Integer userId) {
        try {

            return ResponseEntity.ok(userTypeService.deleteUserById(userId));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/user")
    public ResponseEntity saveUserDataNew(@RequestBody UserDataVO userDataVO) {
        try {

            return ResponseEntity.ok(userTypeService.saveUser(userDataVO));


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/updateuser")
    public ResponseEntity updateUserData(@RequestBody UserDataEntity userDataEntity) {
        try {
            //  System.out.println(userDataEntity.toString());

     //       return ResponseEntity.ok(userTypeService.updateUserById(userDataEntity));
return null;

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }
}