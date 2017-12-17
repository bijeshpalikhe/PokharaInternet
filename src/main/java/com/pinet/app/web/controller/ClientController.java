
package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.EmployeeRolesEntity;
import com.pinet.app.model.*;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.EmployeeInfoService;
import com.pinet.app.service.EmployeeRolesService;
import com.pinet.app.service.UserServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.security.Principal;
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

    @Autowired
    EmployeeRolesService employeeRolesService;

    @Autowired
    EmployeeInfoService employeeInfoService;



    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @RequestMapping(value = "/addcustomer", method = RequestMethod.GET)
    public String addCustomer(Model model) {
        model.addAttribute("clientVO", new ClientVO());
        return "add-customer";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String assignService(@ModelAttribute ClientVO clientVO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        try {
            if (service.checkUsernameUnique(clientVO.getUsername())) {
                return "redirect:/client/addcustomer?uniqueConstraintsError";
            }
            ClientDataResponse clientDataResponse = null;
            clientDataResponse = service.saveUser(clientVO, currentPrincipalName);
            //assign service
            return "redirect:/servicetype/services/" + clientDataResponse.getClientId();
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/clients")
    public String getAllClients(Model model) {

        List response = null;
        try {
            response = service.getAllClients();
            if (response != null) {
                model.addAttribute("clients", response);
            }
            return "manage-customer";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    //For viewing Customer
    @RequestMapping(method = RequestMethod.GET, value = "/{clientId}")
    public String getClientById(@PathVariable("clientId") Integer clientId, Model model) {
        try {
            ClientDataResponse clientDataResponse = service.getClientsById(clientId);
            UserServicesResponse userServicesResponse = servicesService.getServiceDetails(clientId);
            if (clientDataResponse != null && userServicesResponse !=null) {
                model.addAttribute("client", clientDataResponse);
                model.addAttribute("userService", userServicesResponse);
                return "view-customer";

            }else{
                throw  new PokharaInternetException("CAnnot get the Service or client of ID : "+clientId);
            }
        } catch (Exception e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/delete/{clientId}")
    public String deleteClient(@PathVariable("clientId") Integer clientId) {
        try {
            service.deleteClientById(clientId);
            return "redirect:/client/clients";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{clientId}")
    public String editClient(@PathVariable("clientId") Integer clientId, Model model) {
        ClientDataResponse clientDataResponse = null;
        try {
            clientDataResponse = service.getClientsById(clientId);
            if (clientDataResponse != null) {
                ClientVO clientVO = new ClientVO(clientDataResponse);
                model.addAttribute("client", clientVO);
            }
            return "edit-customer";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();

        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String updateUserData(@RequestParam("clientId") Integer clientId, @ModelAttribute ClientVO clientVO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ClientDataResponse response = null;
        try {
            response = service.updateClientById(clientVO, clientId, currentPrincipalName);
            return "redirect:/client/clients";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

    //Assign Ticket
    @RequestMapping(method = RequestMethod.GET, value = "/assignticket/{clientId}")
    public String assignTicket(@PathVariable("clientId") Integer clientId, Model model) {
        return "redirect:/ticket/assignticket/" + clientId;
    }
}

