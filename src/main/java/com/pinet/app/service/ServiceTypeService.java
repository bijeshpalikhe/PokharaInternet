package com.pinet.app.service;

import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.model.ServiceReponse;
import com.pinet.app.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijesh on 7/17/2017.
 */
@Service
public class ServiceTypeService {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public ServiceReponse saveServiceType(String servicedetail, String bandwidth) {

        ServiceTypeEntity serviceTypeEntityToSave = new ServiceTypeEntity();

        serviceTypeEntityToSave.setService(servicedetail);
        serviceTypeEntityToSave.setBandwidth(bandwidth);

        ServiceTypeEntity savedData = serviceTypeRepository.save(serviceTypeEntityToSave);

        ServiceReponse response = new ServiceReponse(savedData.getId(), savedData.getService(), savedData.getBandwidth());
        return response;
    }

    public List<ServiceReponse> getServiceType() {
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findAll();
        List<ServiceReponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceReponse reponse = new ServiceReponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth());
            responseList.add(reponse);
        }
        return responseList;
    }

    public List<ServiceReponse> getServiceTypeByServiceType(String serviceTpye) {
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findByService(serviceTpye);
        List<ServiceReponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceReponse reponse = new ServiceReponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth());
            responseList.add(reponse);
        }
        return responseList;
    }

    public List<ServiceReponse> getServiceTypeByBandwidth(String bandwidth) {
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findByBandwidth(bandwidth);
        List<ServiceReponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceReponse reponse = new ServiceReponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth());
            responseList.add(reponse);
        }
        return responseList;
    }




}
