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
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employeeinfo")
public class EmployeeInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoController.class);

    @Autowired
    EmployeeInfoService service;

    @RequestMapping(value = "/addemployee", method = RequestMethod.GET)
    public String addEmployee(Model model) {
        model.addAttribute("employeeInfoVo", new EmployeeInfoVO());
        return "add-user";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute EmployeeInfoVO employeeInfoVO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        EmployeeInfoResponse employeeInfoResponse = null;
        try {
            employeeInfoResponse = service.saveEmployeeInfo(employeeInfoVO, currentPrincipalName);
            return "redirect:/employeeroles/roles/" + employeeInfoResponse.getEmployeeId();

        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();

        }

    }


    //viewiing all clients
    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    public String getAllEmployees(Model model)  {
        List<EmployeeInfoResponse> response = null;
        try {
            response = service.getAllEmployee();
            if (response == null) {
                throw  new PokharaInternetException("Cannot Get the Employee Details");
            }
            model.addAttribute("employees", response);
            return "manage-user";

        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }



    }

    @RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
    public String getEmpoyeeById(@PathVariable("employeeId") Integer employeeId, Model model) {
        try {
            EmployeeInfoResponse employeeInfoResponse = service.getEmployeeID(employeeId);
            if (employeeInfoResponse == null) {
                throw new PokharaInternetException("Cannot get the Employee Details of : " + employeeId);
            }
            model.addAttribute("employee", employeeInfoResponse);
            return "view-user";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

//    @RequestMapping(method = RequestMethod.GET, value = "employeeUsername/{employeeUsername}")
//    public String getEmployeeByEmail(@PathVariable("employeeUsername") String employeeUsername, Model model) {
//        try {
//            EmployeeInfoResponse employeeInfoResponse = service.getEmployeeByUsername(employeeUsername);
//            if (employeeInfoResponse == null) {
//                throw new PokharaInternetException("Cannot get the Employee Details of : " + employeeUsername);
//            }
//            model.addAttribute("employee", employeeInfoResponse);
//            return "view-user";
//        } catch (PokharaInternetException e) {
//            return "redirect:/exception/error?q=" + e.getMessage();
//        }
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId
    ) {
        try {
            if (service.deleteEmployeeById(employeeId) == false) {
                throw new PokharaInternetException("Cannot Delete Employee please Check the Database");
            }
            return "redirect:/employeeinfo/employees";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{employeeId}")
    public String editEmployee(@PathVariable("employeeId") Integer employeeId,
                           Model model) {

        EmployeeInfoResponse employeeInfoResponse = null;
        try {
            employeeInfoResponse = service.getEmployeeID(employeeId);
            EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO(employeeInfoResponse);
            model.addAttribute("employee", employeeInfoVO);
            return "edit-user";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();

        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String updateEmployeeData(@RequestParam("employeeId") Integer employeeId, @ModelAttribute EmployeeInfoVO employeeInfoVO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        EmployeeInfoResponse response = null;
        try {
            response = service.updateEmployeeInfoById(employeeInfoVO, employeeId, currentPrincipalName);
            return "redirect:/employeeinfo/employees";
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();

        }
    }

    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employees")
//    public ResponseEntity getAllEmployees() {
//        try {
//            LOGGER.info("Received request to get the EmployeeInfoService");
//
//            List<EmployeeInfoResponse> employeeInfoResponses = service.getAllEmployee();
//
//            if (!employeeInfoResponses.isEmpty()) {
//                LOGGER.info("Sending the response to get the EmployeeInfo");
//                return ResponseEntity.ok(employeeInfoResponses);
//            } else {
//                LOGGER.warn("Sending No Data Found Response for Getting all Employees ");
//                return ResponseEntity.status(HttpStatus.OK).body(" No Employees Data Found ");
//            }
//
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Received request to get the EmployeeInfoService Error : "+e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeId}")
//    public ResponseEntity getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
//        try {
//            LOGGER.info("Received request to get the EmployeeInfo with id : "+employeeId);
//            EmployeeInfoResponse employeeInfoResponse = service.getEmployeeID(employeeId);
//            if (employeeInfoResponse != null) {
//                LOGGER.info("Sending response to show EmployeeInfo with id : "+employeeId);
//                return ResponseEntity.ok(employeeInfoResponse);
//            } else {
//                LOGGER.warn("Cannot get the employee with employeeId : "+employeeId+" No data found");
//                return ResponseEntity.status(HttpStatus.OK).body("Employee with Employee ID: " + employeeId + " Not Found ");
//            }
//
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannnot GET EmployeeInfo Response [ERROR] "+e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//            //return ResponseEntity.noContent().build();
//        }
//    }
//
////    @Secured({"ROLE_USER","ROLE_ADMIN"})
////    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/employee/{employeeName}")
////    public ResponseEntity getEmployeeByName(@PathVariable String employeeName) {
////        try {
////
////            return ResponseEntity.ok(employeeInfoService.getEmployeeByName(employeeName));
////
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResponseEntity.noContent().build();
////        }
////
////
////    }
//
//    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
//    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/employee")
//    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeInfoVO employeeInfoVO, @RequestParam(value = "employeeName") String employeeName) {
//        try {
//            LOGGER.debug("Received request to create the Employee : ", employeeInfoVO);
//            EmployeeInfoResponse employeeInfoResponse = service.saveEmployeeInfo(employeeInfoVO, employeeName);
//            if (employeeInfoResponse != null) {
//                LOGGER.info(" employeeInfo Response is not null ");
//
//                return ResponseEntity.ok(employeeInfoResponse);
//
//            } else {
//                return ResponseEntity.status(HttpStatus.CONFLICT).body("Cannot save Data");
//            }
//
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot POST Employee Info [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//    }
//
//    //    @Secured("ROLE_ADMIN")
//    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", value = "/employee/{employeeid}")
//    public ResponseEntity updateUserData(@RequestBody EmployeeInfoVO employeeInfoVO, @PathVariable("employeeid") Integer employeeId, @RequestParam("employeename") String employeeName) {
//        try {
//            LOGGER.info("Received request to Update the Employee : ", employeeInfoVO+" with EmployeeId : "+employeeId+" by Employee : "+employeeName);
//            EmployeeInfoResponse response = service.updateEmployeeInfoById(employeeInfoVO, employeeId, employeeName);
//            if (response != null) {
//                return ResponseEntity.ok(response);
//
//            } else {
//                LOGGER.info(" employeeInfo Response is not null ");
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with UserId : " + employeeId + " Cannot Updated !");
//
//            }
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot UPDATE Employee Info [ERROR]  : " + e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//    }
//
//    //    @Secured("ROLE_ADMIN")
//    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/employee/{employeeId}")
//    public ResponseEntity deleteUserById(@PathVariable("employeeId") Integer employeeId) {
//        try {
//            LOGGER.info("Received request to Delete the Employee  with EmployeeId : "+employeeId);
//            String response = service.deleteEmployeeById(employeeId);
//            if (response != null) {
//                LOGGER.info(" DELETE employeeInfo Response is not null ");
//                return ResponseEntity.ok(response);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with UserId : " + employeeId + " Not found !");
//            }
//        } catch (PokharaInternetException e) {
//            e.printStackTrace();
//            LOGGER.error("Cannot DELETE Employee Information [ERROR]  : " + e.getMessage());
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//
//
//    }

}