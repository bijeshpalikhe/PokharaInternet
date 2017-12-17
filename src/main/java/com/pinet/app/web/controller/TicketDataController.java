package com.pinet.app.web.controller;


import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.model.*;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.EmployeeInfoService;
import com.pinet.app.service.TicketDataService;
import com.pinet.app.service.TicketTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketDataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRolesController.class);

    @Autowired
    TicketDataService ticketDataService;
    @Autowired
    EmployeeInfoService employeeInfoService;
    @Autowired
    TicketTypeService ticketTypeService;
    @Autowired
    ClientDataService clientDataService;


    //assignticket
    @RequestMapping(method = RequestMethod.GET, value = "/assignticket/{clientId}")
    public String getClientDetailsAndAssign(@PathVariable("clientId") Integer clientId, Model model)  {
        ClientDataResponse clientDataResponse= null;
        try {
            clientDataResponse = clientDataService.getClientsById(clientId);
            List<EmployeeInfoResponse> employeeInfoResponses = employeeInfoService.getAllEmployee();
            List<TicketTypeResponse> ticketTypeResponses = ticketTypeService.getAllTickets();

            if (employeeInfoResponses != null && ticketTypeResponses != null) {
                model.addAttribute("client",clientDataResponse);
                model.addAttribute("employees", employeeInfoResponses);
                model.addAttribute("tickets", ticketTypeResponses);

                TicketDataVO ticketDataVO = new TicketDataVO();
                ticketDataVO.setClientUsername(clientDataResponse.getUserName());
                model.addAttribute("ticketDataVo", ticketDataVO);
                return "assign-ticket";
            }else{
                throw new PokharaInternetException(" Cannot Get Employee Data OR Ticket DAta ");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error(" Cannot Client Details of Id : "+clientId+" [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }


    }

    @RequestMapping(method = RequestMethod.POST, value = "/assignticket")
    public String assignTicket(@ModelAttribute TicketDataVO ticketDataVO)  {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        String name=ticketDataVO.getAssignedTo();
        String split[]=name.split(",");
        ticketDataVO.setEmail(split[1]);
        ticketDataVO.setAssignedTo(split[0]);
        ticketDataVO.setClientUsername(ticketDataVO.getClientUsername());
        try {
            TicketDataResponse ticketDataResponse = ticketDataService.saveTicket(ticketDataVO, currentPrincipalName);
        if(ticketDataResponse!=null){
            return "redirect:/dashboard";
        }else{
            throw  new PokharaInternetException("Cannot Assign ticket Data to employees into the DB");
        }
        } catch (PokharaInternetException e) {
            LOGGER.error(" Cannot Assign Ticket to the employee Details of Id  [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }

    }

    //Add Tickets
    @RequestMapping(value = "/addticket", method = RequestMethod.GET)
    public String addTicket(Model model) {
        List<EmployeeInfoResponse> employeeInfoResponses = null;
        try {
            employeeInfoResponses = employeeInfoService.getAllEmployee();
            List<TicketTypeResponse> ticketTypeResponses = ticketTypeService.getAllTickets();
            if (employeeInfoResponses != null && ticketTypeResponses != null) {
                model.addAttribute("employees", employeeInfoResponses);
                model.addAttribute("tickets", ticketTypeResponses);
                TicketDataVO ticketDataVO = new TicketDataVO();
                model.addAttribute("ticketDataVo", ticketDataVO);
                return "add-ticket";
            }

        } catch (PokharaInternetException e) {
            e.printStackTrace();
        }
        return "redirect:/ticket/addticket?error";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addticket")
    public String assignService(@ModelAttribute TicketDataVO ticketDataVO) { Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        String name=ticketDataVO.getAssignedTo();
        String split[]=name.split(",");
        ticketDataVO.setEmail(split[1]);
        ticketDataVO.setAssignedTo(split[0]);
        ticketDataVO.setClientUsername(ticketDataVO.getClientUsername());
        Date currentDate=new Date();
        if(ticketDataVO.getTimeToComplete().getTime() < currentDate.getTime()){
            return "redirect:/ticket/addticket?invalidDate";
        }
        TicketDataResponse ticketDataResponse = null;
        try {
            ticketDataResponse = ticketDataService.saveTicket(ticketDataVO, currentPrincipalName);
            return "redirect:/dashboard";

        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }

    }

    //Viewing all tickets
    @RequestMapping(method = RequestMethod.GET, value = "/tickets")
    public String getAllTickets(Model model) {
        List<TicketDataResponse> response = null;
        Integer totalTicketCount= null;
        try {
            totalTicketCount = ticketDataService.getTotalTicketsValue();
            Integer totalActiveTicketCount=ticketDataService.getActiveTicketValue();
            response = ticketDataService.getAllTickets();
            if (response != null) {
                model.addAttribute("tickets", response);
                model.addAttribute("totalTicketCount",totalTicketCount);
                model.addAttribute("totalActiveTicketCount",totalActiveTicketCount);
                return "manage-ticket";
            }else{
                throw  new PokharaInternetException("Cannot get all the tickets Please check the parameter");
            }
        } catch (PokharaInternetException e) {
            LOGGER.error(" Cannot Get the list of Tickets  [ERROR]  : " + e.getMessage());
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public String getTicketById(@PathVariable("ticketId") Integer ticketId, Model model) {
        TicketDataResponse ticketDataResponse = null;
        try {
            ticketDataResponse = ticketDataService.getTicketById(ticketId);
            if (ticketDataResponse != null) {
                model.addAttribute("ticket", ticketDataResponse);
                return "view-ticket";
            }else{
                throw  new PokharaInternetException("Ticket of Id : "+ticketId+" cannot Found");
            }
        } catch (PokharaInternetException e) {
            return "redirect:/exception/error?q=" + e.getMessage();
        }
    }
}
