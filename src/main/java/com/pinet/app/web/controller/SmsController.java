package com.pinet.app.web.controller;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.mail.EmailService;
import com.pinet.app.model.ClientDataResponse;
import com.pinet.app.model.ClientVO;
import com.pinet.app.model.ServiceResponse;
import com.pinet.app.model.UserServicesResponse;
import com.pinet.app.service.ServiceTypeService;
import com.pinet.app.service.UserServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/sms")
public class SmsController implements EmailService {

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    UserServicesService userServicesService;

    @Autowired
    private JavaMailSender emailSender;

    @RequestMapping(value = "/sendsms", method = RequestMethod.GET)
    public String addCustomer(Model model) {
//        List<ClientDataEntity> clientDataEntities= servicesService.getclientID(serviceId);
        List<ServiceResponse> response = serviceTypeService.getServiceType();
        if (response != null) {
            model.addAttribute("services", response);
            model.addAttribute("userService", new UserServicesResponse());
            return "sms";
        } else {
            return "redirect:/sms/sendsms?serviceError";
        }
    }

    @RequestMapping(value = "/sendsms", method = RequestMethod.POST)
    public String assignService(@ModelAttribute UserServicesResponse userServicesResponse) throws PokharaInternetException {
        List<ClientDataEntity> clientDataEntities = userServicesService.getClientsByServiceId(userServicesResponse.getServiceId());
        String phoneNo;
        for(ClientDataEntity clientDataEntity : clientDataEntities){
                phoneNo=clientDataEntity.getPhoneNo();
            String emailAddress=clientDataEntity.getEmail();
            sendSimpleMessage(emailAddress,"Welcome Regards","Welcome to Pokhara Internet mailing service");

        }
//            List<ClientDataEntity> clientDataEntities=user

// if(service.checkUsernameUnique(clientVO.getUsername())){
//            System.out.println("The Username is already Used");
//            return "redirect:/client/addcustomer?uniqueConstraintsError";
//        }
//        ClientDataResponse clientDataResponse = service.saveUser(clientVO, "arjun");
        return "redirect:/dashboard";//+ clientDataResponse.getClientId();
    }


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
