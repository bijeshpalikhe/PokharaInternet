
package com.pinet.app.web.controller;

import com.pinet.app.model.ClientVO;
import com.pinet.app.model.UserServiceVo;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.UserServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ashmeet on 7/19/17.
 */

@RestController
@RequestMapping(value = "/userservice")
public class UserServicesController {
    @Autowired
    UserServicesService service;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUserServiceData(@RequestBody UserServiceVo userServiceVo, @RequestParam("employeeName") String employeeName) {
        try {
            return ResponseEntity.ok(service.saveUserServices(userServiceVo, employeeName));

        } catch (Exception e) {
            return new ResponseEntity(e.getCause(), HttpStatus.NO_CONTENT);
        }

    }
}

