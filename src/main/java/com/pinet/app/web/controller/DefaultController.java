package com.pinet.app.web.controller;

import com.pinet.app.dao.UserDataEntity;
import com.pinet.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET, value = "/insert")
    public String insertData() {
        return  userService.insertUser();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/update")
    public String updateData() {
        return  (userService.updateUser(2));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/view")
    public String readData() {


        return  (userService.readSingleUser(1));
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDataEntity> readAllData() {


        return  (userService.findAllUsers());
    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete")
    public String deleteUser() {


        return  (userService.deleteUser(3));
    }
}
