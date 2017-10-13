package com.pinet.app.service;


import com.google.gson.Gson;
import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.UserDataEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeInfoService {

    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    public EmployeeInfoDataResponse saveEmployeeInfo(EmployeeInfoDataVO employeeInfoDataVO, String employeeName) {
        EmployeeInfoEntity employeeInfoEntity = new EmployeeInfoEntity(employeeInfoDataVO);


        employeeInfoEntity.setCreatedBy(employeeName);
        java.util.Date utilDate = new java.util.Date();
        employeeInfoEntity.setCreatedDate(utilDate);
        employeeInfoEntity.setLastModifiedBy(employeeName);
        employeeInfoEntity.setLastModifiedDate(utilDate);


        employeeInfoEntity.setInfo(convertInfoToString(employeeInfoDataVO.getInfoVO()));
        employeeInfoEntity.setEmployeesName(convertNameToString(employeeInfoDataVO.getEmployeesName()));

        EmployeeInfoEntity savedEmployee = employeeInfoRepository.save(employeeInfoEntity);
        EmployeeInfoDataResponse employeeInfoDataResponse = new EmployeeInfoDataResponse(savedEmployee);

        employeeInfoDataResponse.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
        employeeInfoDataResponse.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

        return employeeInfoDataResponse;

    }

    public EmployeeInfoDataResponse getEmployeeID(Integer employeeId) {
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);

        if (employeeInfoEntity != null) {
            EmployeeInfoDataResponse employeeInfoDataResponse = new EmployeeInfoDataResponse(employeeInfoEntity);
            employeeInfoDataResponse.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
            employeeInfoDataResponse.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

            return employeeInfoDataResponse;
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

    public List<EmployeeInfoDataResponse> getAllEmployee() {
        List<EmployeeInfoEntity> employeeInfoEntities = employeeInfoRepository.findAll();
        List<EmployeeInfoDataResponse> employeeList = new ArrayList<>();

        for (EmployeeInfoEntity employeeInfoEntity : employeeInfoEntities) {

            EmployeeInfoDataResponse response = new EmployeeInfoDataResponse(employeeInfoEntity);
            response.setInfo(convertStringToInfo(employeeInfoEntity.getInfo()));
            response.setEmployeesName(convertStringToName(employeeInfoEntity.getEmployeesName()));

            employeeList.add(response);
//            response.setInstallationAddress(convertStringToAddress(userDataEntity.getInstallationAddress()));
//            response.setAddress(convertStringToAddress(userDataEntity.getAddress()));
        }
        return employeeList;
    }

    public EmployeeInfoDataResponse updataEmployeeInfoById(EmployeeInfoDataVO employeeInfoDataVO, Integer employeeId, String employeeName) {
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);
        if (employeeInfoEntity != null) {

            employeeInfoEntity.setEmployeesName(convertNameToString(employeeInfoDataVO.getEmployeesName()));
            employeeInfoEntity.setInfo(convertInfoToString(employeeInfoDataVO.getInfoVO()));



            employeeInfoEntity.setEmail(employeeInfoDataVO.getEmail());

            employeeInfoEntity.setDob(employeeInfoDataVO.getDob());
            employeeInfoEntity.setIdType(employeeInfoDataVO.getIdType());
            employeeInfoEntity.setFileNo(employeeInfoDataVO.getFileNo());


            java.util.Date utilDate = new java.util.Date();

            employeeInfoEntity.setLastModifiedDate(utilDate);
            String lastModifiedBY = employeeInfoEntity.getLastModifiedBy() + "," + employeeName;
            employeeInfoEntity.setLastModifiedBy(lastModifiedBY);

            EmployeeInfoEntity savedUser = employeeInfoRepository.save(employeeInfoEntity);
            EmployeeInfoDataResponse response = new EmployeeInfoDataResponse(savedUser);

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
