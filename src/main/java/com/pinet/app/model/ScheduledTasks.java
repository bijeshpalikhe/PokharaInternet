package com.pinet.app.model;


import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.TicketDataEntity;
import com.pinet.app.mail.EmailService;
import com.pinet.app.service.TicketDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks implements EmailService {
    @Autowired
    TicketDataService ticketDataService;

    @Autowired
    private JavaMailSender emailSender;

    List<TicketDataResponse> ticketDataResponses = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() throws PokharaInternetException {
        Date currentDate = new Date();
        long currentTime = Math.abs(currentDate.getTime());

        ticketDataResponses = ticketDataService.getAllTickets();

        for (TicketDataResponse ticketDataResponse : ticketDataResponses) {
            if (ticketDataResponse.getTimeToComplete() != null && ticketDataResponse.getActive() !=false) {
                Date dueDate=ticketDataResponse.getTimeToComplete();
                long timeDiff = Math.abs(currentDate.getTime() - dueDate.getTime());

                if(TimeUnit.MINUTES.toDays(timeDiff) < 50L){
                    log.error("YOU are going to expire in 50 seconds : "+ticketDataResponse.getAssignedTo());
                    String emailAddress=ticketDataResponse.getEmployeeEmail();
                    sendSimpleMessage(emailAddress,"Ticket Notification","Your ticket is going to expire in 50 seconds");
                    ticketDataService.update(ticketDataResponse.getTicketId(), ticketDataResponse.getActive());
                    return;
                }
                log.warn("DEADLINE TIME: "+TimeUnit.MINUTES.toDays(Math.abs(dueDate.getTime()))+" OF : "+ticketDataResponse.getAssignedTo());
                log.warn("REMAINING TIME : " +  TimeUnit.MINUTES.toDays(timeDiff)+" OF : "+ticketDataResponse.getAssignedTo());
            }
        }
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