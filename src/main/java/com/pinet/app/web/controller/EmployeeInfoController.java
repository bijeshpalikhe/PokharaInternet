package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.EmployeeInfoResponse;
import com.pinet.app.model.EmployeeInfoVO;
import com.pinet.app.service.EmployeeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeinfo")
public class EmployeeInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoController.class);
    @Autowired
    EmployeeInfoService employeeInfoService;

    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employees")
    public ResponseEntity getAllEmployees() {
        try {
            LOGGER.info("Received request to get the EmployeeInfoService");

            List<EmployeeInfoResponse> employeeInfoResponses = employeeInfoService.getAllEmployee();
            if (employeeInfoResponses != null) {
                LOGGER.info("Sending the response to get the EmployeeInfo");
                return ResponseEntity.ok(employeeInfoResponses);
            } else {
                LOGGER.warn("Received request to get the EmployeeInfoService No Data Found ");
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Data Found");
            }

        } catch (PokharaInternetException e) {
            e.printStackTrace();
            LOGGER.error("Received request to get the EmployeeInfoService Error : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        try {
            LOGGER.info("Received request to get the EmployeeInfo with id : "+employeeId);
            EmployeeInfoResponse employeeInfoResponse = employeeInfoService.getEmployeeID(employeeId);
            if (employeeInfoResponse != null) {
                LOGGER.info("Sending response to show EmployeeInfo with id : "+employeeId);
                return ResponseEntity.ok(employeeInfoResponse);
            } else {
                LOGGER.warn("CAnnot get the employee with employeeId : "+employeeId+" No data found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with Employee ID: " + employeeId + " Not Found ");
            }

        } catch (PokharaInternetException e) {
            e.printStackTrace();
            LOGGER.error("Error in gettling the employee with id : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            //return ResponseEntity.noContent().build();
        }
    }

//    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeName}")
//    public ResponseEntity getEmployeeByName(@PathVariable String employeeName) {
//        try {
//
//            return ResponseEntity.ok(employeeInfoService.getEmployeeByName(employeeName));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.noContent().build();
//        }
//
//
//    }

    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/employee")
    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeInfoVO employeeInfoVO, @RequestParam(value = "employeeName") String employeeName) {
        try {
            LOGGER.debug("Received request to create the Employee : ", employeeInfoVO);
            EmployeeInfoResponse employeeInfoResponse = employeeInfoService.saveEmployeeInfo(employeeInfoVO, employeeName);
            if (employeeInfoResponse != null) {
                return ResponseEntity.ok(employeeInfoResponse);

            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot save Data");
            }

        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/employee/{employeeid}")
    public ResponseEntity updateUserData(@RequestBody EmployeeInfoVO employeeInfoVO, @PathVariable("employeeid") Integer employeeId, @RequestParam("employeename") String employeeName) {
        try {
            LOGGER.info("Received request to Update the Employee : ", employeeInfoVO+" with EmployeeId : "+employeeId+" by Employee : "+employeeName);

            EmployeeInfoResponse response = employeeInfoService.updateEmployeeInfoById(employeeInfoVO, employeeId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Cannot Updated !");

            }
        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    //    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity deleteUserById(@PathVariable("employeeId") Integer employeeId) {
        try {
            LOGGER.info("Received request to Delete the Employee  with EmployeeId : "+employeeId);
            String response = employeeInfoService.deleteEmployeeById(employeeId);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with UserId : " + employeeId + " Not found !");
            }
        } catch (PokharaInternetException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }


    }

}