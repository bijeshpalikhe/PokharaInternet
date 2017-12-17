package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.*;
import com.pinet.app.service.ServiceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bijesh on 7/17/2017.
 */

@Controller
@RequestMapping(value = "/servicetype")
public class ServiceTypeController {
    @Autowired
    ServiceTypeService serviceTypeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTypeController.class);

    @RequestMapping(value = "/addservice", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("serviceVo", new ServiceVO());
        return "add-service";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addService(@ModelAttribute ServiceVO serviceVO) {
        try {
            LOGGER.info("Received request for saving  the Service Inforamation in database");
            serviceTypeService.saveServiceType(serviceVO);
            LOGGER.info(" Service  data saved successfully in Database ");
            return "redirect:/servicetype/manageservice";
        } catch (PokharaInternetException e) {
            LOGGER.error("Cannot POST Service Data  [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/manageservice")
    public String getAllServices(Model model) {
        List<ServiceResponse> response = null;
        try {
            LOGGER.info("Received request for Getting all Service Inforamation from database");
            response = serviceTypeService.getServiceType();
            if (response != null) {
                model.addAttribute("services", response);
                LOGGER.info(" Service data fetched successfully from Database and added to the View manage-service.html");
                return "manage-service";
            } else {
                throw new PokharaInternetException(" Cannot get Service Data please check the DB");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error("Cannot Get All Services Data  [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/services/{clientId}")
    public String getAllService(@PathVariable("clientId") Integer clientId, Model model) {
        List<ServiceResponse> response = null;
        try {
            LOGGER.info("Received request for Getting  Service Inforamation from database from to Assignt to the particular client of Client ID : "+clientId);
            response = serviceTypeService.getServiceType();
            if (response != null) {
                model.addAttribute("services", response);
                UserServiceVo userServiceVo = new UserServiceVo();
                userServiceVo.setClientId(clientId);
                model.addAttribute("userServiceVo", userServiceVo);
                LOGGER.info(" Service data fetched successfully from Database and added to the View assign-service.html");
                return "assign-service";
            } else {
                throw new PokharaInternetException("Cannot get the services Please check the DB");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error("Cannot Get Services Data  [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{serviceId}")
    public String getServiceById(@PathVariable("serviceId") Integer serviceId, Model model) {
        ServiceResponse serviceResponse = null;
        try {
            LOGGER.info("Received request for Getting  Service Inforamation from database with serviceId : "+serviceId);
            serviceResponse = serviceTypeService.getServiceById(serviceId);
            if (serviceResponse != null) {
                model.addAttribute("service", serviceResponse);
                LOGGER.info(" Service data fetched successfully from Database and added to the View view-service.html");
                return "view-service";

            } else {
                throw new PokharaInternetException("Cannot get the service with Id " + serviceId + " Please check the DB");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error("Cannot Get Services Data of Id : "+serviceId+" [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();

        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/edit/{serviceId}")
    public String editService(@PathVariable("serviceId") Integer serviceId, Model model) {

        ServiceResponse serviceResponse = null;
        try {
            LOGGER.info("Received request for Editing  Service Inforamation from database with serviceId : "+serviceId);
            serviceResponse = serviceTypeService.getServiceById(serviceId);
            if (serviceResponse != null) {
                ServiceVO serviceVO = new ServiceVO(serviceResponse);
                model.addAttribute("service", serviceVO);
                LOGGER.info(" Service data fetched successfully from Database and added to the View edit-service.html");
                return "edit-service";
            } else {
                throw new PokharaInternetException("Cannot Edit the service with id : " + serviceId);
            }
        } catch (PokharaInternetException e) {
            LOGGER.error(" Service Data of Id : "+serviceId+" Not found for edit [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String updateServiceData(@RequestParam("serviceId") Integer serviceId, @ModelAttribute ServiceVO serviceVO) {
        ServiceResponse response = null;
        try {
            LOGGER.info("Received request for Updating  Service Inforamation from database with serviceId : "+serviceId);
            response = serviceTypeService.updateServiceType(serviceVO, serviceId);
            if (response != null) {
                LOGGER.info(" Service data Updated successfully to Database redirecting to manage service view page");
                return "redirect:/servicetype/manageservice";
            } else {
                throw new PokharaInternetException("Cannot update service with Id  " + serviceId + " Please review the DB");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error(" Cannot update Service Data of Id : "+serviceId+" [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();

        }
    }

}
