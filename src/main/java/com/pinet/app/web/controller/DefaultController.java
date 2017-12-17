package com.pinet.app.web.controller;


import com.pinet.app.model.EmployeeInfoResponse;
import com.pinet.app.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bijesh on 4/19/2017.
 */

@Controller
@Secured({"ROLE_ADMIN","ROLE_USER"})

//@RequestMapping(value = "")
public class DefaultController {

    @Autowired
    EmployeeInfoService employeeInfoService;

//    @RequestMapping()
//    public String testMessage() {
//        return "Greetings from Pinet";
//    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

//    @GetMapping("/")
//    public String showDashboard(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        System.out.println("Principal Name : "+authentication.getPrincipal());
////        String currentPrincipalName = authentication.getName();
////        EmployeeInfoResponse employeeInfoResponse=employeeInfoService.getEmployeeByUsername(currentPrincipalName);
////        model.addAttribute("username",currentPrincipalName);
////        model.addAttribute("employee",employeeInfoResponse);
//
//        return "dashboard";
//
//    }
    @GetMapping("/dashboard")
    public String dashboard(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        EmployeeInfoResponse employeeInfoResponse=employeeInfoService.getEmployeeByUsername(currentPrincipalName);
//        model.addAttribute("username",currentPrincipalName);
//        model.addAttribute("employee",employeeInfoResponse);

        return "dashboard";

    }
//
//    @GetMapping("/")
//    public String dashboard() {
//        return "dashboard";
//    }

//    @GetMapping("/dashboard")
//    public String dashboardPage() {
//        return "dashboard";
//    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/due")
    public String dueDate() {
        return "due-date";
    }

//    @GetMapping("/accessdenied")
//    public String accessDenied() {
//        return "access-denied";
//    }
//
//    @GetMapping("/addcustomer")
//    public String addcustomer() {
//        return "add-customer";
//    }
//
//
//    @GetMapping("/managecustomer")
//    public String managecustomer() {
//        return "manage-customer";
//    }
//    @GetMapping("/addservice")
//    public String addservice() {
//        return "add-service";
//    }
//    @GetMapping("/viewservice")
//    public String viewservice() {
//        return "view-service";
//    }
//    @GetMapping("/manageservice")
//    public String manageservice() {
//        return "manage-service";
//    }
//    @GetMapping("/adduser")
//    public String adduser() {
//        return "add-user";
//    }
//    @GetMapping("/viewuser")
//    public String viewuser() {
//        return "view-user";
//    }
//    @GetMapping("/manageuser")
//    public String manageuser() {
//        return "manage-user";
//    }
//    @GetMapping("/addticket")
//    public String addticket() {
//        return "add-ticket";
//    }
//    @GetMapping("/viewticket")
//    public String viewticket() {
//        return "view-ticket";
//    }
//    @GetMapping("/manageticket")
//    public String manageticket() {
//        return "manage-ticket";
//    }
//    @Secured(value="ROLE_ADMIN")

    @RequestMapping("/test")
    public String showAccess(){
        return "Test Authroized ";
    }
    @Secured(value="ROLE_USER")
    @RequestMapping("/user")
    public String showAccessToUser(){
        return "User Authroized ";
    }
//    @Secured(value="ROLE_ADMIN")
    @RequestMapping("/admin")
    public String showAdminAccess(){
        return "Admin Authroized ";
    }
}
