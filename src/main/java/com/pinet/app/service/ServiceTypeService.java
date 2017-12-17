package com.pinet.app.service;

import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.model.ClientDataResponse;
import com.pinet.app.model.ServiceResponse;
import com.pinet.app.model.ServiceVO;
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

    public ServiceResponse saveServiceType(ServiceVO serviceVO) throws PokharaInternetException {

        ServiceTypeEntity serviceTypeEntityToSave = new ServiceTypeEntity();

        serviceTypeEntityToSave.setService(serviceVO.getServiceType());
        serviceTypeEntityToSave.setBandwidth(serviceVO.getBandwidth());

        ServiceTypeEntity savedData = serviceTypeRepository.save(serviceTypeEntityToSave);

        ServiceResponse response = new ServiceResponse(savedData.getId(), savedData.getService(), savedData.getBandwidth(),savedData.getNotes());
        return response;
    }

    public ServiceResponse updateServiceType(ServiceVO serviceVO, Integer id) throws PokharaInternetException {
        ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.findOne(id);
        if (serviceTypeEntity != null) {

//            ServiceTypeEntity serviceTypeEntityToSave = new ServiceTypeEntity();

            serviceTypeEntity.setService(serviceVO.getServiceType());
            serviceTypeEntity.setBandwidth(serviceVO.getBandwidth());

            ServiceTypeEntity savedData = serviceTypeRepository.save(serviceTypeEntity);

            ServiceResponse response = new ServiceResponse(savedData.getId(), savedData.getService(), savedData.getBandwidth(), savedData.getNotes());
            return response;
        }
        return null;
    }

    public List<ServiceResponse> getServiceType() throws PokharaInternetException {
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findAll();
        List<ServiceResponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceResponse reponse = new ServiceResponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth(),serviceTypeEntity.getNotes());
            responseList.add(reponse);
        }
        return responseList;
    }

    public List<ServiceResponse> getServiceTypeByServiceType(String serviceTpye) throws PokharaInternetException{
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findByService(serviceTpye);
        List<ServiceResponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceResponse reponse = new ServiceResponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth(), serviceTypeEntity.getNotes());
            responseList.add(reponse);
        }
        return responseList;
    }

    public List<ServiceResponse> getServiceTypeByBandwidth(String bandwidth) throws PokharaInternetException{
        List<ServiceTypeEntity> serviceTypeEntityList = serviceTypeRepository.findByBandwidth(bandwidth);
       if(serviceTypeEntityList!=null){

       }
        List<ServiceResponse> responseList = new ArrayList<>();

        for (ServiceTypeEntity serviceTypeEntity : serviceTypeEntityList) {

            ServiceResponse reponse = new ServiceResponse(serviceTypeEntity.getId(), serviceTypeEntity.getService(), serviceTypeEntity.getBandwidth(), serviceTypeEntity.getNotes());
            responseList.add(reponse);
        }
        return responseList;
    }


    public ServiceResponse getServiceById(Integer serviceId) throws PokharaInternetException{

        ServiceTypeEntity serviceTypeEntity = serviceTypeRepository.findOne(serviceId);
        if (serviceTypeEntity != null) {
            ServiceResponse response = new ServiceResponse(serviceTypeEntity);
            return response;
        } else {
            return null;
        }
    }
}
