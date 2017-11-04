package com.pinet.app.web.controller;

import com.pinet.app.model.EmployeeInfoResponse;
import com.pinet.app.model.EmployeeInfoVO;
import com.pinet.app.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employeeinfo")
public class EmployeeInfoController {
    @Autowired
    EmployeeInfoService employeeInfoService;

    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employees")
    public ResponseEntity getAllEmployees() {
        try {

            return ResponseEntity.ok(employeeInfoService.getAllEmployee());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }
    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        try {

            return ResponseEntity.ok(employeeInfoService.getEmployeeID(employeeId));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
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
    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeInfoVO employeeInfoVO, @RequestParam(value="employeeName") String employeeName) {
        try {

            return ResponseEntity.ok(employeeInfoService.saveEmployeeInfo(employeeInfoVO,employeeName));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }
    //    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/employee/{employeeid}")
    public ResponseEntity updateUserData(@RequestBody EmployeeInfoVO employeeInfoVO, @PathVariable("employeeid") Integer employeeId, @RequestParam("employeename") String employeeName) {
        try {

            EmployeeInfoResponse response = employeeInfoService.updateEmployeeInfoById(employeeInfoVO, employeeId, employeeName);
            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }

    }

    //    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/employee/{employeeId}")
    public ResponseEntity deleteUserById(@PathVariable("employeeId") Integer employeeId) {
        try {

            String response = employeeInfoService.deleteEmployeeById(employeeId);

            if (response != null) {
                return ResponseEntity.ok(response);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");

            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

}