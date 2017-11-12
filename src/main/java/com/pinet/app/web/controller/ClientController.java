
package com.pinet.app.web.controller;

import com.pinet.app.model.ClientVO;
import com.pinet.app.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ashmeet on 7/19/17.
 */

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    ClientDataService service;

   /* @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/users")
    public ResponseEntity getUsers() {
        try {

            return ResponseEntity.ok(userDataService.getAllUsers());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }*/

   /* @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer userId) {
        try {
            ClientDataResponse response = userDataService.getUserById(userId);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }*/

   /* @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/user/{userId}")
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


    }*/

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUserData(@RequestBody ClientVO userDataVO, @RequestParam("employeeName") String employeeName) {
        try {

            return ResponseEntity.ok(service.saveUser(userDataVO, employeeName));

        } catch (Exception e) {
            return new ResponseEntity(e.getCause(), HttpStatus.NO_CONTENT);
        }

    }

   /* @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/user/{userId}")
    public ResponseEntity updateUserData(@RequestBody ClientVO userDataVO, @PathVariable("userId") Integer userId, @RequestParam("employeeName") String employeeName) {
        try {

            ClientDataResponse response = userDataService.updateUserById(userDataVO, userId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }*/
}

