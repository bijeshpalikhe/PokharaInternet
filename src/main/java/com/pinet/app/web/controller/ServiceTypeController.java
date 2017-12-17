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
    public String addService(@ModelAttribute ServiceVO serviceVO) throws PokharaInternetException {

        serviceTypeService.saveServiceType(serviceVO);
        return "redirect:/dashboard";

    }


    @RequestMapping(method = RequestMethod.GET, value = "/manageservice")
    public String getAllServices(Model model) throws PokharaInternetException {
        List<ServiceResponse> response = serviceTypeService.getServiceType();
        if (response != null) {
            model.addAttribute("services", response);
        }
        return "manage-service";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/services/{clientId}")
    public String getAllService(@PathVariable("clientId") Integer clientId, Model model) throws PokharaInternetException {
        List<ServiceResponse> response = serviceTypeService.getServiceType();
        if (response != null) {
            model.addAttribute("services", response);
            UserServiceVo userServiceVo=new UserServiceVo();
            userServiceVo.setClientId(clientId);
            model.addAttribute("userServiceVo", userServiceVo);
        }
        return "assign-service";

    }



    @RequestMapping(method = RequestMethod.GET, value = "/{serviceId}")
    public String getClientById(@PathVariable("serviceId") Integer serviceId,
                                @RequestParam("employeeName") String employeeName, Model model) {
        ServiceResponse serviceResponse = serviceTypeService.getServiceById(serviceId);
        if (serviceResponse != null) {
            model.addAttribute("service", serviceResponse);
//                return ResponseEntity.ok("view-customer");
            return "view-service";

        }
//             else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + clientId + " Not found !");
//            }

        return "redirect:/dashboard";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/edit/{serviceId}")
    public String editService(@PathVariable("serviceId") Integer serviceId, Model model) throws PokharaInternetException {

        ServiceResponse serviceResponse = serviceTypeService.getServiceById(serviceId);

        if (serviceResponse != null) {
            ServiceVO serviceVO=new ServiceVO(serviceResponse);
            model.addAttribute("service",serviceVO );
//            model.addAttribute("service", serviceResponse);

            return "edit-service";
        }
//        System.out.println("Clinet DAta EDIT E");
        return "redirect:/dashboard";

    }


    @RequestMapping(method = RequestMethod.POST, value = "/update" )
    public String updateUserData(@RequestParam ("serviceId") Integer serviceId, @ModelAttribute ServiceVO serviceVO) {

//        ServiceVO serviceVO=new ServiceVO(serviceResponse);
        ServiceResponse response = serviceTypeService.updateServiceType(serviceVO,serviceId);
        if (response != null) {

            return "redirect:/dashboard";
//                return ResponseEntity.ok(response);

        }
//             else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");
//
//            }
        return "redirect:/view-service";

    }




//    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    public ResponseEntity saveServiceType(@RequestParam("serviceDetail") String serviceDetail, @RequestParam("bandwidth") String bandwidth) {
//        try {
//            LOGGER.info("Received request for saving  the Service Inforamation");
//            ServiceResponse serviceResponse = serviceTypeService.saveServiceType(serviceDetail, bandwidth);
//            if(serviceResponse!=null){
//                LOGGER.info(" Service  data saved successfully ");
//                return ResponseEntity.ok(serviceResponse);
//            } else {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot save Service Data");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot POST Service Data  [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    public ResponseEntity getServices() {
//        try {
//            LOGGER.info("Received request to get the Service Data ");
//
//            List<ServiceResponse> serviceResponses=serviceTypeService.getServiceType();
//            if(serviceResponses!=null){
//                return ResponseEntity.ok(serviceResponses);
//            }else{
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot Get Service Data");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot GET  Service Data  [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/searchbyservice/{serviceType}")
//    public ResponseEntity getServicesByServiceType(@PathVariable("serviceType") String serviceType) {
//        try {
//            List<ServiceResponse> serviceResponses=serviceTypeService.getServiceTypeByServiceType(serviceType);
//
//            if(serviceResponses!=null) {
//                return ResponseEntity.ok(serviceResponses);
//            }else{
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot Get Service Data By serviceType");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot GET  Service Data By serviceType [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/searchbybandwidth/{bandwidth}")
//    public ResponseEntity getServicesByBandwidth(@PathVariable("bandwidth") String bandwidth) {
//        try {
//
//            List<ServiceResponse> serviceResponses = serviceTypeService.getServiceTypeByBandwidth(bandwidth);
//            if (serviceResponses != null) {
//                return ResponseEntity.ok(serviceResponses);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot Get Service Data By bandwith");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot GET  Service Data By bandwith [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }

}
