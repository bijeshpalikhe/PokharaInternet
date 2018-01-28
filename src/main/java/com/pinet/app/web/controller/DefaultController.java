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
public class DefaultController {

    @Autowired
    EmployeeInfoService employeeInfoService;

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/")
    public String defaultLoginPage() {
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


}
