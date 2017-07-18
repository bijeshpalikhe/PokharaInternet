package com.pinet.app.web.controller;

import com.pinet.app.model.ServiceReponse;
import com.pinet.app.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bijesh on 7/17/2017.
 */

@RestController
@RequestMapping(value = "/servicetype")
public class ServiceTypeController {

    @Autowired
    ServiceTypeService serviceTypeService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveServiceType(@RequestParam("serviceDetail") String serviceDetail, @RequestParam("bandwidth") String bandwidth) {
        try {
            ServiceReponse reponse = serviceTypeService.saveServiceType(serviceDetail, bandwidth);
            return ResponseEntity.ok(reponse);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getServices() {
        try {

            return ResponseEntity.ok(serviceTypeService.getServiceType());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/searchbyservice/{serviceType}")
    public ResponseEntity getServicesByServiceType(@PathVariable("serviceType") String serviceType) {
        try {

            return ResponseEntity.ok(serviceTypeService.getServiceTypeByServiceType(serviceType));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/searchbybandwidth/{bandwidth}")
    public ResponseEntity getServicesByBandwidth(@PathVariable("bandwidth") String bandwidth) {
        try {

            return ResponseEntity.ok(serviceTypeService.getServiceTypeByBandwidth(bandwidth));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }


}
