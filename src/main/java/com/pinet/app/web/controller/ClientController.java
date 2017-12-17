
package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.ClientDataResponse;
import com.pinet.app.model.ClientVO;
import com.pinet.app.model.ServiceVO;
import com.pinet.app.model.UserServicesResponse;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.UserServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;


/**
 * Created by ashmeet on 7/19/17.
 */

@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    ClientDataService service;

    @Autowired
    UserServicesService servicesService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("clientVO", new ClientVO());
        return "add-customer";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String assignService(@ModelAttribute ClientVO clientVO) throws PokharaInternetException {
        if(service.checkUsernameUnique(clientVO.getUsername())){
            return "redirect:/client/addcustomer?uniqueConstraintsError";
        }
        ClientDataResponse clientDataResponse = service.saveUser(clientVO, "arjun");
        return "redirect:/servicetype/services/"+ clientDataResponse.getClientId();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    public String getAllClients(Model model) throws PokharaInternetException {
        List response = service.getAllClients();

        if (response != null) {
            model.addAttribute("clients", response);
        }
        return "manage-customer";

    }


    //For viewing Customer
    @RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
    public String getClientById(@PathVariable("clientId") Integer clientId,
                                @RequestParam("employeeName") String employeeName, Model model) {
        try {
            ClientDataResponse clientDataResponse = service.getClientsById(clientId);
            UserServicesResponse userServicesResponse= servicesService.getServiceDetails(clientId);

            if (clientDataResponse != null) {
                model.addAttribute("client", clientDataResponse);
                model.addAttribute("userService", userServicesResponse);

                return "view-customer";
            }
        } catch (PokharaInternetException e) {
            return "redirect:/client/view-customer?error";
        }
        return "redirect:/client/view-customer?error";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId
    ) throws PokharaInternetException {

        if (service.deleteClientById(clientId)) {
            return "redirect:/client/clients";
        }
        return "redirect:/dashboard";

    }


    //    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{clientId}")
//    public ResponseEntity getClientById(@PathVariable("clientId") Integer clientId, @RequestParam("employeeName") String employeeName) {
//        try {
//            ClientDataResponse response = service.getClientsById(clientId);
//            if (response != null) {
//                return ResponseEntity.ok(response);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + clientId + " Not found !");
//
//            }
//
//        } catch (PokharaInternetException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//
//    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUserData(@RequestBody ClientVO userDataVO, @RequestParam("employeeName") String employeeName) {
        try {
            return ResponseEntity.ok(service.saveUser(userDataVO, employeeName));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getMessage());
        }


    }

//    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/{userId}")
//    public ResponseEntity updateUserData(@RequestBody ClientVO userDataVO,
//                                         @PathVariable("userId") Integer userId,
//                                         @RequestParam("employeeName") String employeeName,
//                                         Model model) {
//        try {
//
//            ClientDataResponse response = service.updateClientById(userDataVO, userId, employeeName);
//            if (response != null) {
//                return ResponseEntity.ok(response);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");
//
//            }
//        } catch (PokharaInternetException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//    }


    @RequestMapping(method = RequestMethod.GET, value = "/edit/{clientId}")
    public String editClient(@PathVariable("clientId") Integer clientId,
                             Model model) throws PokharaInternetException {

        ClientDataResponse clientDataResponse = service.getClientsById(clientId);

        if (clientDataResponse != null) {
            ClientVO clientVO = new ClientVO(clientDataResponse);
            model.addAttribute("client", clientVO);
            return "edit-customer";
        }
        return "view-customer";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String updateUserData(@RequestParam("clientId") Integer clientId, @ModelAttribute ClientVO clientVO) throws PokharaInternetException {
        ClientDataResponse response = service.updateClientById(clientVO, clientId, "arjun");
        if (response != null) {
            return "redirect:/dashboard";
        }
        return "redirect:/client/edit-customer";
    }


    //Assign Ticket
    @RequestMapping(method = RequestMethod.GET, value = "/assignticket/{clientId}")
    public String assignTicket(@PathVariable("clientId") Integer clientId,
                               Model model) throws PokharaInternetException {

        return "redirect:/ticket/assignticket/" + clientId;


    }


//    @RequestMapping(method = RequestMethod.POST, value = "/update" ,consumes = {"application/x-www-form-urlencoded"})
//    public String updateUserData(@ModelAttribute ClientDataResponse clientDataResponse) {
//        try {
//        ClientVO clientVO=new ClientVO(clientDataResponse);
//            ClientDataResponse response = service.updateClientById(clientVO, "arjunn");
//            if (response != null) {
//                return "edit-customer";
////                return ResponseEntity.ok(response);
//
//            }
////             else {
////                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");
////
////            }
//        } catch (PokharaInternetException e) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//        return "edit-customer";
//
//    }
}

