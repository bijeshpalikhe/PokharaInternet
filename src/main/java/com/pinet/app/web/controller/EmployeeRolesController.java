package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.EmployeeInfoResponse;
import com.pinet.app.model.EmployeeInfoVO;
import com.pinet.app.model.EmployeeRolesResponse;
import com.pinet.app.model.EmployeeRolesVo;
import com.pinet.app.service.EmployeeInfoService;
import com.pinet.app.service.EmployeeRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employeeroles")
public class EmployeeRolesController {
    @Autowired
    EmployeeRolesService employeeRolesService;

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeRolesController.class);


    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/roles/{employeeId}")
    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeRolesVo employeeRolesVo,@PathVariable("employeeId") Integer employeeId, @RequestParam(value="employeeName") String employeeName) {
        try {
            EmployeeRolesResponse employeeRolesResponse=employeeRolesService.saveEmployeeRoles(employeeRolesVo,employeeId,employeeName);
           LOGGER.info("Received POST request for Roles  having Employee Id : "+employeeId);
            if(employeeRolesResponse!=null) {
                LOGGER.info("Employee Response is not null ");
               return ResponseEntity.ok(employeeRolesResponse);
           }else{
                LOGGER.warn("Cannot save Employee Roles and Credentials");
               return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot save Employee Roles and Credentials");
           }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Cannot save Employeer Roles and Credentials  : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }


    }

    //    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/employee/{employeeid}")
    public ResponseEntity updateEmployeeRolesData(@RequestBody EmployeeRolesVo employeeRolesVo, @PathVariable("employeeid") Integer employeeId, @RequestParam("employeename") String employeeName) {
        try {

            EmployeeRolesResponse response = employeeRolesService.updateEmployeeRolesById(employeeRolesVo, employeeId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity deleteUserById(@PathVariable("employeeId") Integer employeeId) {
        try {

            String response = employeeRolesService.deleteEmployeeRolesById(employeeId);

            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");

            }
        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity getEmployeeRolesById(@PathVariable("employeeId") Integer employeeId) {
        try {

            EmployeeRolesResponse employeeRolesResponse = employeeRolesService.getEmployeeRoles(employeeId);

            if (employeeRolesResponse != null) {
                return ResponseEntity.ok(employeeRolesResponse);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");
            }
        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }

}