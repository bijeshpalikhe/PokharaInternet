package com.pinet.app.service;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.TicketDataEntity;
import com.pinet.app.model.TicketDataResponse;
import com.pinet.app.model.TicketDataVO;
import com.pinet.app.repository.TicketDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketDataService {

    @Autowired
    TicketDataRepository ticketDataRepository;

    public TicketDataResponse saveTicket(TicketDataVO ticketDataVO, String employeeName) throws PokharaInternetException {
        TicketDataEntity ticketDataEntity = new TicketDataEntity(ticketDataVO);

        ticketDataEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

//        clientDataEntity.setDob(sqlDate);

        ticketDataEntity.setCreatedDate(sqlDate);
        ticketDataEntity.setLastModifiedBy(employeeName);
        ticketDataEntity.setLastModifiedDate(sqlDate);
        TicketDataEntity savedTicket = ticketDataRepository.save(ticketDataEntity);
        TicketDataResponse response = new TicketDataResponse(savedTicket);
        return response;
    }

    public List<TicketDataResponse> getAllTickets() {
        List<TicketDataEntity> ticketDataEntities = ticketDataRepository.findAll();
        List<TicketDataResponse> userList = new ArrayList<>();

        for (TicketDataEntity ticketDataEntity : ticketDataEntities) {

            TicketDataResponse response = new TicketDataResponse(ticketDataEntity);
            userList.add(response);
        }
        return userList;
    }
    public TicketDataResponse getTicketById(Integer ticketId) {
        TicketDataEntity ticketEntity = ticketDataRepository.findOne(ticketId);
            TicketDataResponse response = new TicketDataResponse(ticketEntity);
        return response;
    }


    public void update(Integer ticketId, Boolean active) {
        TicketDataEntity ticketEntity = ticketDataRepository.findOne(ticketId);
        ticketEntity.setActive(active);
        ticketDataRepository.save(ticketEntity);
    }
}

