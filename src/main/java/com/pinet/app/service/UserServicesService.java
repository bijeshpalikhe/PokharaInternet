package com.pinet.app.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.entities.UserServicesEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.ClientDataRepository;
import com.pinet.app.repository.ServiceTypeRepository;
import com.pinet.app.repository.UserServicesRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by bpalikhe on 7/19/17.
 */

@Service
public class UserServicesService {


    @Autowired
    UserServicesRepository userServicesRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;


    public UserServicesResponse saveUserServices(UserServiceVo userServiceVo, String employeeName) throws PokharaInternetException {

        UserServicesEntity userServicesEntity = new UserServicesEntity();

        ClientDataEntity clientDataEntity = new ClientDataEntity(userServiceVo.getClientId());
        ServiceTypeEntity serviceTypeEntity = new ServiceTypeEntity(userServiceVo.getServiceId());

        userServicesEntity.setInstallationAddress(convertAddresstojson(userServiceVo.getInstallationAddress()));

        userServicesEntity.setActive(userServiceVo.getActive());
        userServicesEntity.setClientID(clientDataEntity);
        userServicesEntity.setServiceTypeEntity(serviceTypeEntity);
        userServicesEntity.setConnectedArea(userServiceVo.getConnectedArea());
        userServicesEntity.setCreatedBy(employeeName);
        userServicesEntity.setLastModifiedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        userServicesEntity.setCreatedDate(sqlDate);
        userServicesEntity.setLastModifiedDate(sqlDate);
        UserServicesEntity savedUserServicesEntity = userServicesRepository.save(userServicesEntity);
        UserServicesResponse response = new UserServicesResponse(savedUserServicesEntity);
        response.setInstallationAddress(convertJsonToAddress(savedUserServicesEntity.getInstallationAddress()));

        return response;
    }

    public UserServicesResponse getServiceDetails(Integer clientId) throws PokharaInternetException {
        ClientDataEntity clientDataEntity = new ClientDataEntity();
        clientDataEntity.setClientId(clientId);

        UserServicesEntity userServicesEntity = userServicesRepository.findByClientID(clientDataEntity);
        if (userServicesEntity == null) {
            return null;
        }
        UserServicesResponse response = new UserServicesResponse(userServicesEntity);
        String serviceName = serviceTypeRepository.findOne(response.getServiceId()).getService();
        if (serviceName != null) {
            return null;
        } else {
            response.setServiceName(serviceName);
            return response;
        }
    }

    public List<ClientDataEntity> getClientsByServiceId(Integer serviceId) throws PokharaInternetException {
        List<ClientDataEntity> entities = new ArrayList<>();
        ServiceTypeEntity serviceTypeEntity = new ServiceTypeEntity();
        serviceTypeEntity.setId(serviceId);
        List<UserServicesEntity> userServicesEntity = userServicesRepository.findByserviceTypeEntity(serviceTypeEntity);
        for (UserServicesEntity entity : userServicesEntity) {
            entities.add(entity.getClientID());
        }
        return entities;
    }

    private String convertAddresstojson(AddressVo addressVo) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(addressVo);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }


    }

    private AddressVo convertJsonToAddress(String address) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AddressVo jsonInString = mapper.readValue(address, AddressVo.class);
            return jsonInString;
        } catch (IOException e) {
            e.printStackTrace();
            throw new PokharaInternetException(e.getMessage());
        }


    }

}


