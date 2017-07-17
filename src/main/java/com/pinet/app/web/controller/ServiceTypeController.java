package com.pinet.app.web.controller;

import com.pinet.app.model.ServiceReponse;
import com.pinet.app.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bijesh on 7/17/2017.
 */

@RestController
@RequestMapping(value = "/servicetype")
public class ServiceTypeController {

    @Autowired
    ServiceTypeService serviceTypeService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity savePhone(@RequestParam("serviceDetail") String serviceDetail, @RequestParam("bandwidth") String bandwidth) {
        try {
            ServiceReponse reponse = serviceTypeService.saveServiceType(serviceDetail, bandwidth);
            return ResponseEntity.ok(reponse);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }
}
