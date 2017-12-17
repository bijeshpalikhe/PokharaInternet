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

    String employeeName="arjun";

    //assignticket
    @RequestMapping(method = RequestMethod.GET, value = "/assignticket/{clientId}")
    public String getClientDetailsAndAssign(@PathVariable("clientId") Integer clientId, Model model) throws PokharaInternetException {
        ClientDataResponse clientDataResponse= clientDataService.getClientsById(clientId);
//        LOGGER.error("Client username : " + clientDataResponse.getUserName());
        List<EmployeeInfoResponse> employeeInfoResponses = employeeInfoService.getAllEmployee();
        List<TicketTypeResponse> ticketTypeResponses = ticketTypeService.getAllTickets();
        if (employeeInfoResponses != null && ticketTypeResponses != null) {
            model.addAttribute("client",clientDataResponse);
            model.addAttribute("employees", employeeInfoResponses);
            model.addAttribute("tickets", ticketTypeResponses);

            TicketDataVO ticketDataVO = new TicketDataVO();
            ticketDataVO.setClientUsername(clientDataResponse.getUserName());
//            ticketDataVO.set(clientId);
            model.addAttribute("ticketDataVo", ticketDataVO);
        }
        return "assign-ticket";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/assignticket")
    public String assignTicket(@ModelAttribute TicketDataVO ticketDataVO) throws PokharaInternetException {
        String name=ticketDataVO.getAssignedTo();
        String split[]=name.split(",");
        ticketDataVO.setEmail(split[1]);
        ticketDataVO.setAssignedTo(split[0]);
        ticketDataVO.setClientUsername(ticketDataVO.getClientUsername());
        TicketDataResponse ticketDataResponse = ticketDataService.saveTicket(ticketDataVO, "arjun");
        return "redirect:/dashboard";

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
    public String assignService(@ModelAttribute TicketDataVO ticketDataVO) throws PokharaInternetException {
        String name=ticketDataVO.getAssignedTo();
        String split[]=name.split(",");
        ticketDataVO.setEmail(split[1]);
        ticketDataVO.setAssignedTo(split[0]);
        ticketDataVO.setClientUsername(ticketDataVO.getClientUsername());
        Date currentDate=new Date();
        if(ticketDataVO.getTimeToComplete().getTime() < currentDate.getTime()){
            return "redirect:/ticket/addticket?invalidDate";
        }
        TicketDataResponse ticketDataResponse = ticketDataService.saveTicket(ticketDataVO, employeeName);
        if(ticketDataResponse!=null){
            return "redirect:/dashboard";
        }else {
            return "redirect:/ticket/addticket?saveError";
        }
    }

    //Viewing all tickets
    @RequestMapping(method = RequestMethod.GET, value = "/tickets")
    public String getAllTickets(Model model) throws PokharaInternetException {
        List<TicketDataResponse> response = ticketDataService.getAllTickets();

        if (response != null) {
            model.addAttribute("tickets", response);
        }
        return "manage-ticket";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public String getTicketById(@PathVariable("ticketId") Integer ticketId, Model model) {
        TicketDataResponse ticketDataResponse = ticketDataService.getTicketById(ticketId);
        if (ticketDataResponse != null) {
            model.addAttribute("ticket", ticketDataResponse);
            return "view-ticket";
        }
        return "redirect:/dashboard";
    }
}
