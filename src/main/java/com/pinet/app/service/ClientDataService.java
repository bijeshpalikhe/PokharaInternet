package com.pinet.app.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.ClientDataRepository;
import com.pinet.app.repository.UserServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ashmeet on 7/19/17.
 */

@Service
public class ClientDataService {


    @Autowired
    ClientDataRepository clientDataRepository;

    @Autowired
    UserServicesRepository userServicesRepository;

    public ClientDataResponse saveUser(ClientVO clientVO, String employeeName) throws PokharaInternetException {
        NameVO nameVO = new NameVO(clientVO.getFname(), clientVO.getMname(), clientVO.getLname());
        ClientDataVO dataVO = new ClientDataVO(clientVO.getGender(), clientVO.getNationality(), clientVO.getCitizenNo(), clientVO.getPassportNo(), clientVO.getFatherName(), clientVO.getOccupationType());
        AddressVo addressVo = new AddressVo(clientVO.getHouseNo(), clientVO.getWardNo(), clientVO.getStreetName(), clientVO.getMunicipality(), clientVO.getDistrict(), clientVO.getZone(), clientVO.getCountry());
        ClientDataEntity clientDataEntity = new ClientDataEntity(clientVO);
        clientDataEntity.setClientName(convertNametojson(nameVO));
        clientDataEntity.setClientData(convertDatatojson(dataVO));
        clientDataEntity.setAddress(convertAddresstojson(addressVo));
        clientDataEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        clientDataEntity.setCreatedDate(sqlDate);
        clientDataEntity.setLastModifiedBy(employeeName);
        clientDataEntity.setLastModifiedDate(sqlDate);
        ClientDataEntity savedClient = saveClientEntity(clientDataEntity);
        ClientDataResponse response = convertClientEntityToResponse(savedClient);
        return response;
    }

    public List<ClientDataResponse> getAllClients() throws PokharaInternetException {
        List<ClientDataEntity> userDataEntityList = clientDataRepository.findAll();
        List<ClientDataResponse> userList = new ArrayList<>();

        for (ClientDataEntity clientDataEntity : userDataEntityList) {

            ClientDataResponse response = convertClientEntityToResponse(clientDataEntity);
            userList.add(response);
        }
        return userList;
    }


    public ClientDataResponse getClientsById(Integer userId) throws PokharaInternetException {

        ClientDataEntity userDataEntity = clientDataRepository.findOne(userId);
        if (userDataEntity != null) {
            ClientDataResponse response = convertClientEntityToResponse(userDataEntity);
            return response;
        } else {
            return null;
        }

    }

    public Boolean checkUsernameUnique(String username) throws  PokharaInternetException{
        ClientDataEntity clientDataEntity=clientDataRepository.findByUserName(username);
        if(clientDataEntity!=null){
            return true;
        }
        return false;

    }

//    public ClientVO getClientsById(Integer userId) throws PokharaInternetException {
//
//        ClientDataEntity userDataEntity = clientDataRepository.findOne(userId);
//        if (userDataEntity != null) {
//            ClientVO clientVO = convertClientEntityToResponse(userDataEntity);
//            return response;
//        } else {
//            return null;
//        }
//
//    }

//    public String deleteClientById(Integer clientId, String employeeName) throws PokharaInternetException {
//        ClientDataEntity client = clientDataRepository.findOne(clientId);
//        if (client == null) {
//            return null;
//        } else {
//            try {
//                clientDataRepository.delete(client.getClientId());
//                System.out.println("****user deleted by " + employeeName + " ClientDetails : " + client.toString());
//                return "User successfully deleted";
//            } catch (DataIntegrityViolationException e) {
//                System.out.println("Cause" + e.getCause());
//                System.out.println("Message" + e.getMessage());
//                e.printStackTrace();
//
//                throw new PokharaInternetException("Error deleting the user, Please check for active services");
//            }
//
//        }
//    }
    public Boolean deleteClientById(Integer clientId) throws PokharaInternetException {
        ClientDataEntity client = clientDataRepository.findOne(clientId);
        if (client == null) {
            return null;
        } else {
            try {
                userServicesRepository.delete(client.getClientId());
                clientDataRepository.delete(client.getClientId());
                return true;
            } catch (DataIntegrityViolationException e) {
                System.out.println("Cause" + e.getCause());
                System.out.println("Message" + e.getMessage());
                e.printStackTrace();

                throw new PokharaInternetException("Error deleting the user, Please check for active services");
            }

        }
    }

    public ClientDataResponse updateClientById(ClientVO clientVO, String employeeName) throws PokharaInternetException {
        if (clientVO != null) {
            NameVO nameVO = new NameVO(clientVO.getFname(), clientVO.getMname(), clientVO.getLname());
            ClientDataVO dataVO = new ClientDataVO(clientVO.getGender(), clientVO.getNationality(), clientVO.getCitizenNo(), clientVO.getPassportNo(), clientVO.getFatherName(), clientVO.getOccupationType());
            AddressVo addressVo = new AddressVo(clientVO.getHouseNo(), clientVO.getWardNo(), clientVO.getStreetName(), clientVO.getMunicipality(), clientVO.getDistrict(), clientVO.getZone(), clientVO.getCountry());

            ClientDataEntity clientDataEntity = new ClientDataEntity(clientVO);


            clientDataEntity.setUserName(clientVO.getUsername());
            clientDataEntity.setDob(clientVO.getDob());
            clientDataEntity.setEmail(clientVO.getEmail());
            clientDataEntity.setMobileNo(clientVO.getMobileNo());
            clientDataEntity.setPhoneNo(clientVO.getPhoneNo());
            clientDataEntity.setClientName(convertNametojson(nameVO));
            clientDataEntity.setClientData(convertDatatojson(dataVO));
            clientDataEntity.setAddress(convertAddresstojson(addressVo));
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            clientDataEntity.setDob(sqlDate);
            clientDataEntity.setLastModifiedBy(employeeName);
            clientDataEntity.setLastModifiedDate(sqlDate);
            ClientDataEntity savedClient = saveClientEntity(clientDataEntity);
            ClientDataResponse response = convertClientEntityToResponse(savedClient);
            return response;
        } else {
            return null;
        }


    }

    public String convertNametojson(NameVO nameVO) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(nameVO);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }


    }

    public String convertAddresstojson(AddressVo addressVo) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(addressVo);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }


    }

    public String convertDatatojson(ClientDataVO clientDataVO) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(clientDataVO);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }

    }

    public ClientDataResponse convertClientEntityToResponse(ClientDataEntity clientDataEntity) throws PokharaInternetException {
        ClientDataResponse clientDataResponse = new ClientDataResponse(clientDataEntity);
        clientDataResponse.setAddress(convertJsonToAddress(clientDataEntity.getAddress()));
        clientDataResponse.setClientName(convertJsonToName(clientDataEntity.getClientName()));
        clientDataResponse.setClientData(convertJsonToData(clientDataEntity.getClientData()));

        return clientDataResponse;
    }

    public AddressVo convertJsonToAddress(String address) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            AddressVo jsonInString = mapper.readValue(address, AddressVo.class);
            return jsonInString;
        } catch (IOException e) {
            e.printStackTrace();
            throw new PokharaInternetException(e.getMessage());
        }


    }

    public NameVO convertJsonToName(String name) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            NameVO object = mapper.readValue(name, NameVO.class);
            return object;

        } catch (IOException e) {
            e.printStackTrace();
            throw new PokharaInternetException(e.getMessage());
        }


    }

    public ClientDataVO convertJsonToData(String data) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ClientDataVO object = mapper.readValue(data, ClientDataVO.class);
            return object;

        } catch (IOException e) {
            throw new PokharaInternetException(e.getMessage());
        }


    }

    public ClientDataEntity saveClientEntity(ClientDataEntity clientDataEntity) throws PokharaInternetException {
        try {
            ClientDataEntity savedClient = clientDataRepository.save(clientDataEntity);
            return savedClient;
        } catch (Exception e) {
            throw new PokharaInternetException("Error saving in DB, Please check the info");

        }
    }


    public ClientDataResponse updateClientById(ClientVO clientVO, Integer clientId, String employeeName) throws PokharaInternetException {
        ClientDataEntity clientDataEntity = clientDataRepository.findOne(clientId);
        if (clientDataEntity != null) {
            NameVO nameVO = new NameVO(clientVO.getFname(), clientVO.getMname(), clientVO.getLname());
            ClientDataVO dataVO = new ClientDataVO(clientVO.getGender(), clientVO.getNationality(), clientVO.getCitizenNo(), clientVO.getPassportNo(), clientVO.getFatherName(), clientVO.getOccupationType());
            AddressVo addressVo = new AddressVo(clientVO.getHouseNo(), clientVO.getWardNo(), clientVO.getStreetName(), clientVO.getMunicipality(), clientVO.getDistrict(), clientVO.getZone(), clientVO.getCountry());
            clientDataEntity.setUserName(clientVO.getUsername());
            clientDataEntity.setDob(clientVO.getDob());
            clientDataEntity.setEmail(clientVO.getEmail());
            clientDataEntity.setMobileNo(clientVO.getMobileNo());
            clientDataEntity.setPhoneNo(clientVO.getPhoneNo());
            clientDataEntity.setClientName(convertNametojson(nameVO));
            clientDataEntity.setClientData(convertDatatojson(dataVO));
            clientDataEntity.setAddress(convertAddresstojson(addressVo));
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            clientDataEntity.setDob(sqlDate);
            clientDataEntity.setLastModifiedBy(employeeName);
            clientDataEntity.setLastModifiedDate(sqlDate);
            ClientDataEntity savedClient = saveClientEntity(clientDataEntity);
            ClientDataResponse response = convertClientEntityToResponse(savedClient);
            return response;
        } else {
            return null;
        }


    }
}


