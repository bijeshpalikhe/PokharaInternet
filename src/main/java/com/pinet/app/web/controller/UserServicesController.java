
package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.*;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.ServiceTypeService;
import com.pinet.app.service.UserServicesService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ashmeet on 7/19/17.
 */

@Controller
@RequestMapping(value = "/userservice")
public class UserServicesController {
    @Autowired
    UserServicesService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesController.class);

    @RequestMapping(method = RequestMethod.POST, value="/assignservice")
    public String assignService(@ModelAttribute UserServiceVo userServiceVo) throws PokharaInternetException {


        UserServicesResponse userServicesResponse = service.saveUserServices(userServiceVo, "arjun");

        return "redirect:/dashboard";

    }




}

