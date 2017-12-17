package com.pinet.app.service;

import com.pinet.app.entities.TicketTypeEntitiy;
import com.pinet.app.model.TicketDataResponse;
import com.pinet.app.model.TicketDataVO;
import com.pinet.app.model.TicketTypeResponse;
import com.pinet.app.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketTypeService {
    @Autowired
    TicketTypeRepository ticketTypeRepository;

    public List<TicketTypeResponse> getAllTickets(){
        List<TicketTypeEntitiy> ticketTypeEntities = ticketTypeRepository.findAll();
        List<TicketTypeResponse> ticketList = new ArrayList<>();

        for (TicketTypeEntitiy ticketTypeEntitiy : ticketTypeEntities) {

            TicketTypeResponse response = new TicketTypeResponse(ticketTypeEntitiy);
            ticketList.add(response);
        }
        return ticketList;
    }


//    public TicketDataResponse save(TicketDataVO ticketDataVO, String arjun) {
//
//    }
}
