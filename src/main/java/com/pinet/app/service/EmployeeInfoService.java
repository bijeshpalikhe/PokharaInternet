package com.pinet.app.service;


import com.google.gson.Gson;
import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class EmployeeInfoService {

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    public EmployeeInfoResponse saveEmployeeInfo(EmployeeInfoVO employeeInfoVO, String employeeName) {
        EmployeeInfoEntity employeeInfoEntity = new EmployeeInfoEntity(employeeInfoVO);


        employeeInfoEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        employeeInfoEntity.setCreatedDate(utilDate);
        employeeInfoEntity.setLastModifiedBy(employeeName);
        employeeInfoEntity.setLastModifiedDate(utilDate);


        employeeInfoEntity.setInfo(convertInfoToString(employeeInfoVO.getInfoVO()));
        employeeInfoEntity.setEmployeesName(convertNameToString(employeeInfoVO.getEmployeesName()));

        EmployeeInfoEntity savedEmployee = employeeInfoRepository.save(employeeInfoEntity);
        EmployeeInfoResponse employeeInfoResponse = new EmployeeInfoResponse(savedEmployee);

        employeeInfoResponse.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
        employeeInfoResponse.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

        return employeeInfoResponse;

    }

    public EmployeeInfoResponse getEmployeeID(Integer employeeId) {
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);

        if (employeeInfoEntity != null) {
            EmployeeInfoResponse employeeInfoResponse = new EmployeeInfoResponse(employeeInfoEntity);
            employeeInfoResponse.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
            employeeInfoResponse.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

            return employeeInfoResponse;
        }
        return null;
    }

//    public EmployeeInfoDataResponse getEmployeeByName(String employeeName) {
//        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findByEmployeename(employeeName);
//
//        if (employeeInfoEntity != null) {
//            EmployeeInfoDataResponse employeeInfoDataResponse = new EmployeeInfoDataResponse(employeeInfoEntity);
//            return employeeInfoDataResponse;
//        }
//        return null;
//    }

    public List<EmployeeInfoResponse> getAllEmployee() {
        List<EmployeeInfoEntity> employeeInfoEntities = employeeInfoRepository.findAll();
        List<EmployeeInfoResponse> employeeList = new ArrayList<>();

        for (EmployeeInfoEntity employeeInfoEntity : employeeInfoEntities) {

            EmployeeInfoResponse response = new EmployeeInfoResponse(employeeInfoEntity);
            response.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
            response.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

            employeeList.add(response);
//            response.setInstallationAddress(convertStringToAddress(userDataEntity.getInstallationAddress()));
//            response.setAddress(convertStringToAddress(userDataEntity.getAddress()));
        }
        return employeeList;
    }

    public EmployeeInfoResponse updateEmployeeInfoById(EmployeeInfoVO employeeInfoVO, Integer employeeId, String employeeName) {
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);
        if (employeeInfoEntity != null) {

            employeeInfoEntity.setEmployeesName(convertNameToString(employeeInfoVO.getEmployeesName()));
            employeeInfoEntity.setInfo(convertInfoToString(employeeInfoVO.getInfoVO()));



            employeeInfoEntity.setEmail(employeeInfoVO.getEmail());

            employeeInfoEntity.setDob(employeeInfoVO.getDob());
            employeeInfoEntity.setIdType(employeeInfoVO.getIdType());
            employeeInfoEntity.setFileNo(employeeInfoVO.getFileNo());


            java.util.Date utilDate = new java.util.Date();

            employeeInfoEntity.setLastModifiedDate(utilDate);
            String lastModifiedBY = employeeInfoEntity.getLastModifiedBy() + "," + employeeName;
            employeeInfoEntity.setLastModifiedBy(lastModifiedBY);

            EmployeeInfoEntity savedUser = employeeInfoRepository.save(employeeInfoEntity);
            EmployeeInfoResponse response = new EmployeeInfoResponse(savedUser);

            response.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
            response.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));


            return response;

        }
        return null;

    }

    public String deleteEmployeeById(Integer employeeId) {
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);
        if (employeeInfoEntity != null) {
            employeeInfoRepository.delete(employeeInfoEntity);
            return "Employee Deleted Successfully";
        }
        return "Employee cannot be Deleted";

    }





    public String convertInfoToString(InfoVO infoVO) {
        Gson gson = new Gson();
        String json = gson.toJson(infoVO);
        return json;

    }

    public InfoVO convertStringToInfo(String jsonString) {
        Gson gson = new Gson();
        InfoVO infoVO = gson.fromJson(jsonString, InfoVO.class);
        return infoVO;

    }

    public String convertNameToString(NameVO nameVO) {
        Gson gson = new Gson();
        String json = gson.toJson(nameVO);
        return json;

    }

    public NameVO convertStringToName(String jsonString) {
        Gson gson = new Gson();
        NameVO nameVO = gson.fromJson(jsonString, NameVO.class);
        return nameVO;

    }
}
