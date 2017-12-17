package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.EmployeeRolesResponse;
import com.pinet.app.model.EmployeeRolesVo;
import com.pinet.app.service.EmployeeInfoService;
import com.pinet.app.service.EmployeeRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/employeeroles")
public class EmployeeRolesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRolesController.class);
    @Autowired
    EmployeeRolesService service;

    @RequestMapping(method = RequestMethod.GET, value = "/roles/{employeeId}")
    public String getAllRoles(@PathVariable("employeeId") Integer employeeId, Model model)  {
            LOGGER.error("Client id from getAllServices() "+employeeId);
            EmployeeRolesVo employeeRolesVo=new EmployeeRolesVo();
            employeeRolesVo.setEmployeeId(employeeId);
            model.addAttribute("employeeRolesVo", employeeRolesVo);
        return "assign-roles";

    }

    @RequestMapping(method = RequestMethod.POST, value="/assignroles")
    public String assignroles(@ModelAttribute EmployeeRolesVo employeeRolesVo) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        try {
            EmployeeRolesResponse employeeRolesResponse = service.saveEmployeeRoles(employeeRolesVo, currentPrincipalName);
            return "redirect:/dashboard";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();

        }
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/roles/{employeeId}")
//    public String assignRoles(@PathVariable("employeeId") Integer employeeId, Model model) throws PokharaInternetException {
////        List<Em> response = serviceTypeService.getServiceType();
//        if (response != null) {
//            LOGGER.error("Client id from getAllServices() "+clientId);
//            model.addAttribute("services", response);
//            UserServiceVo userServiceVo=new UserServiceVo();
//            userServiceVo.setClientId(clientId);
//            model.addAttribute("userServiceVo", userServiceVo);
//        }
//        return "assign-service";
//
//    }
//
//
//    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/roles/{employeeId}")
//    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeRolesVo employeeRolesVo, @PathVariable("employeeId") Integer employeeId, @RequestParam(value = "employeeName") String employeeName) {
//        try {
//            EmployeeRolesResponse employeeRolesResponse = employeeRolesService.saveEmployeeRoles(employeeRolesVo, employeeId, employeeName);
//            LOGGER.info("Received POST request for Roles  having Employee Id : " + employeeId);
//            if (employeeRolesResponse != null) {
//                LOGGER.info("Employee Response is not null ");
//                return ResponseEntity.ok(employeeRolesResponse);
//            } else {
//                LOGGER.warn("Cannot save Employee Roles and Credentials");
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot save Employee Roles and Credentials");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot save Employeer Roles and Credentials  [ERROR]: " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//
//
//    }
//
//    //    @Secured("ROLE_ADMIN")
//    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/employee/{employeeid}")
//    public ResponseEntity updateEmployeeRolesData(@RequestBody EmployeeRolesVo employeeRolesVo, @PathVariable("employeeid") Integer employeeId, @RequestParam("employeename") String employeeName) {
//        try {
//            LOGGER.info("Received PUT request for Roles  having Employee Id : " + employeeId);
//
//            EmployeeRolesResponse response = employeeRolesService.updateEmployeeRolesById(employeeRolesVo, employeeId, employeeName);
//            if (response != null) {
//                LOGGER.info("Employee Response is not null ");
//                return ResponseEntity.ok(response);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot Update Employee Roles and Credentials [ERROR] : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/employee/{employeeId}")
//    public ResponseEntity deleteUserById(@PathVariable("employeeId") Integer employeeId) {
//        try {
//            LOGGER.info("Received DELETE request for Roles  having Employee Id : " + employeeId);
//
//            String response = employeeRolesService.deleteEmployeeRolesById(employeeId);
//
//            if (response != null) {
//                LOGGER.info("Employee Response is not null ");
//
//                return ResponseEntity.ok(response);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");
//
//            }
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot DELETE Employee Roles and Credentials [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeId}")
//    public ResponseEntity getEmployeeRolesById(@PathVariable("employeeId") Integer employeeId) {
//        try {
//            LOGGER.info("Received GET request for Roles  having Employee Id : " + employeeId);
//            EmployeeRolesResponse employeeRolesResponse = employeeRolesService.getEmployeeRoles(employeeId);
//
//            if (employeeRolesResponse != null) {
//                LOGGER.info("Employee Response is not null ");
//                return ResponseEntity.ok(employeeRolesResponse);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Not found !");
//            }
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot GET Employee Roles and Credentials [ERROR]  : " + e.getMessage());
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//
//    }

}