package com.pinet.app.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.ClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /*


   public ClientDataResponse getUserById(Integer userId) {

       UserDataEntity userDataEntity = userDataRepository.findOne(userId);
       if (userDataEntity != null) {
           ClientDataResponse response = new ClientDataResponse(userDataEntity);
           return response;


       } else {
           return null;
       }


   }

   public String deleteUserById(Integer userId) {
       UserDataEntity user = userDataRepository.findOne(userId);
       if (user == null) {
           return null;
       } else {
           userDataRepository.delete(user);
           return "User successfully deleted";
       }
   }


   public String updateUserById(Integer userId) {
       UserDataEntity user = userDataRepository.findOne(userId);
       ClientVO clientDataVO = new ClientVO(user);

       UserDataEntity savedUser = userDataRepository.save(user);
       return "User updated successfully";
   }

   public ClientDataResponse updateUserById(ClientVO clientDataVO, Integer userId, String employeeName) {
       UserDataEntity user = userDataRepository.findOne(userId);
       if (user != null) {
           user.setName(clientDataVO.getName());
           user.setUsername(clientDataVO.getUsername());
           user.setDob(clientDataVO.getDob());
           user.setGender(clientDataVO.getGender());
           user.setNationality(clientDataVO.getNationality());
           user.setCitizenNo(clientDataVO.getCitizenNo());
           user.setPassportNo(clientDataVO.getPassportNo());
           user.setFatherName(clientDataVO.getFatherName());
           user.setEmail(clientDataVO.getEmail());
           user.setAddress(clientDataVO.getAddress());
           user.setMobileNo(clientDataVO.getMobileNo());
           user.setPhoneNo(clientDataVO.getPhoneNo());
           user.setOccupationType(clientDataVO.getOccupationType());
           user.setServiceCode(clientDataVO.getServiceCode());
           user.setSubscriptionType(clientDataVO.getSubscriptionType());
           user.setInstallationAddress(clientDataVO.getInstallationAddress());
           java.util.Date utilDate = new java.util.Date();

           user.setLastModifiedDate(utilDate);
           String lastModifiedBY = user.getLastModifiedBy() + "," + employeeName;
           user.setLastModifiedBy(lastModifiedBY);

           UserDataEntity savedUser = userDataRepository.save(user);
           ClientDataResponse response = new ClientDataResponse(savedUser);
           return response;
       } else {
           return null;
       }


   }
*/
    private String convertNametojson(NameVO nameVO) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(nameVO);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }


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

    private String convertDatatojson(ClientDataVO clientDataVO) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(clientDataVO);
            return jsonInString;

        } catch (JsonProcessingException e) {
            throw new PokharaInternetException(e.getMessage());
        }

    }

    private ClientDataResponse convertClientEntityToResponse(ClientDataEntity clientDataEntity) throws PokharaInternetException {
        ClientDataResponse clientDataResponse = new ClientDataResponse(clientDataEntity);
        clientDataResponse.setAddress(convertJsonToAddress(clientDataEntity.getAddress()));
        clientDataResponse.setClientName(convertJsonToName(clientDataEntity.getClientName()));
        clientDataResponse.setClientData(convertJsonToData(clientDataEntity.getClientData()));

        return clientDataResponse;
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

    private NameVO convertJsonToName(String name) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            NameVO object = mapper.readValue(name, NameVO.class);
            return object;

        } catch (IOException e) {
            e.printStackTrace();
            throw new PokharaInternetException(e.getMessage());
        }


    }

    private ClientDataVO convertJsonToData(String data) throws PokharaInternetException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ClientDataVO object = mapper.readValue(data, ClientDataVO.class);
            return object;

        } catch (IOException e) {
            throw new PokharaInternetException(e.getMessage());
        }


    }

    private ClientDataEntity saveClientEntity(ClientDataEntity clientDataEntity) throws PokharaInternetException {
        try {
            ClientDataEntity savedClient = clientDataRepository.save(clientDataEntity);
            return savedClient;
        } catch (Exception e) {
            throw new PokharaInternetException(e.getCause().getMessage());

        }
    }


}


