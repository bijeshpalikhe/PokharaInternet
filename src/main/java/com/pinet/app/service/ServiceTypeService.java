package com.pinet.app.service;

import com.pinet.app.entities.ServiceTypeEntity;
import com.pinet.app.model.ServiceReponse;
import com.pinet.app.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
