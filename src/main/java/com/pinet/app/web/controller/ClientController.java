
package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.ClientDataResponse;
import com.pinet.app.model.ClientVO;
import com.pinet.app.service.ClientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ashmeet on 7/19/17.
 */

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    ClientDataService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllClients() {
        try {
            List response = service.getAllClients();

            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found");

            }

        } catch (PokharaInternetException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getMessage());
        }


    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{clientId}")
    public ResponseEntity getClientById(@PathVariable("clientId") Integer clientId, @RequestParam("employeeName") String employeeName) {
        try {
            ClientDataResponse response = service.getClientsById(clientId);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + clientId + " Not found !");

            }

        } catch (PokharaInternetException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/{clientId}")
    public ResponseEntity deleteClientById(@PathVariable("clientId") Integer clientId, @RequestParam("employeeName") String employeeName) {

        String response = null;
        try {
            response = service.deleteClientById(clientId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + clientId + " Not found !");
            }
        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }


    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUserData(@RequestBody ClientVO userDataVO, @RequestParam("employeeName") String employeeName) {
        try {
            return ResponseEntity.ok(service.saveUser(userDataVO, employeeName));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getCause().getMessage());
        }


    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/{userId}")
    public ResponseEntity updateUserData(@RequestBody ClientVO userDataVO, @PathVariable("userId") Integer userId, @RequestParam("employeeName") String employeeName) {
        try {

            ClientDataResponse response = service.updateClientById(userDataVO, userId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + userId + " Not found !");

            }
        } catch (PokharaInternetException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}

