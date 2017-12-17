package com.pinet.app.service;


import com.google.gson.Gson;
import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.EmployeeInfoEntity;
import com.pinet.app.entities.EmployeeRolesEntity;
import com.pinet.app.model.*;
import com.pinet.app.repository.EmployeeInfoRepository;
import com.pinet.app.repository.EmployeeRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeInfoService {
    @Autowired
    EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    EmployeeRolesRepository employeeRolesRepository;

    public EmployeeInfoResponse saveEmployeeInfo(EmployeeInfoVO employeeInfoVO, String employeeName) throws PokharaInternetException {
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

    public EmployeeInfoResponse getEmployeeID(Integer employeeId) throws PokharaInternetException{
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

    public List<EmployeeInfoResponse> getAllEmployee() throws PokharaInternetException{
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

    public EmployeeInfoResponse updateEmployeeInfoById(EmployeeInfoVO employeeInfoVO, Integer employeeId, String employeeName) throws PokharaInternetException{
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

    public Boolean deleteEmployeeById(Integer employeeId) throws PokharaInternetException{
        EmployeeInfoEntity employeeInfoEntity = employeeInfoRepository.findOne(employeeId);
        if (employeeInfoEntity == null) {
            return null;
        } else {
            employeeRolesRepository.delete(employeeId);
            employeeInfoRepository.delete(employeeInfoEntity);
            return true;
        }
    }

    public EmployeeInfoResponse getEmployeeByUsername(String username) throws PokharaInternetException {
        EmployeeRolesEntity employeeRolesEntity=employeeRolesRepository.findByUsername(username);
        EmployeeInfoEntity employeeInfoEntity=employeeInfoRepository.findOne(employeeRolesEntity.getEmployeeId());

        EmployeeInfoResponse response=new EmployeeInfoResponse(employeeInfoEntity);
        return response;

    }


    public String convertInfoToString(InfoVO infoVO) throws PokharaInternetException {
        Gson gson = new Gson();
        String json = gson.toJson(infoVO);
        return json;

    }

    public InfoVO convertStringToInfo(String jsonString) throws PokharaInternetException {
        Gson gson = new Gson();
        InfoVO infoVO = gson.fromJson(jsonString, InfoVO.class);
        return infoVO;

    }

    public String convertNameToString(NameVO nameVO) throws PokharaInternetException {
        Gson gson = new Gson();
        String json = gson.toJson(nameVO);
        return json;

    }

    public NameVO convertStringToName(String jsonString) throws PokharaInternetException{
        Gson gson = new Gson();
        NameVO nameVO = gson.fromJson(jsonString, NameVO.class);
        return nameVO;

    }
}
