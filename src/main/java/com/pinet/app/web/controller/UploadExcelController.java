package com.pinet.app.web.controller;


import com.pinet.app.config.PokharaInternetException;
import com.pinet.app.entities.ClientDataEntity;
import com.pinet.app.model.*;
import com.pinet.app.service.ClientDataService;
import com.pinet.app.service.UserServicesService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/uploadexcel")
public class UploadExcelController {
    @Autowired
    ClientDataService clientDataService;
    @Autowired
    UserServicesService userServicesService;


    ClientVO clientVO = new ClientVO();
    UserServiceVo userServiceVo = new UserServiceVo();

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String uploadFile() {
        return "import-file";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadcustomer")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        if (file.isEmpty()) {
            System.out.println("The Selecte file is emptyl");
        } else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            System.out.println("The selected files in NOT EMPTY : " + currentPrincipalName);

            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            Row row;
            for (int i = 1; i <= worksheet.getLastRowNum(); i++) {
                row = worksheet.getRow(i);
                clientVO.setUsername(row.getCell(0).getStringCellValue());
                clientVO.setFname(row.getCell(1).getStringCellValue());
                clientVO.setMname(row.getCell(2).getStringCellValue());
                clientVO.setLname(row.getCell(3).getStringCellValue());
                clientVO.setGender(row.getCell(4).getStringCellValue().charAt(0));
                clientVO.setNationality(row.getCell(5).getStringCellValue());
                clientVO.setCitizenNo("" + row.getCell(6).getNumericCellValue());
                clientVO.setPassportNo("" + row.getCell(7).getNumericCellValue());
                clientVO.setFatherName(row.getCell(8).getStringCellValue());
                clientVO.setOccupationType(row.getCell(9).getStringCellValue());
                clientVO.setDob(row.getCell(10).getDateCellValue());
                clientVO.setEmail(row.getCell(11).getStringCellValue());
                clientVO.setHouseNo((int) row.getCell(12).getNumericCellValue());
                clientVO.setWardNo((int) row.getCell(13).getNumericCellValue());
                clientVO.setStreetName(row.getCell(14).getStringCellValue());
                clientVO.setMunicipality(row.getCell(15).getStringCellValue());
                clientVO.setDistrict(row.getCell(16).getStringCellValue());
                clientVO.setZone(row.getCell(17).getStringCellValue());
                clientVO.setCountry(row.getCell(18).getStringCellValue());
                clientVO.setPhoneNo("" + row.getCell(19).getNumericCellValue());
                clientVO.setMobileNo("" + row.getCell(20).getNumericCellValue());

                try {
                    ClientDataResponse response = clientDataService.saveUser(clientVO, currentPrincipalName);
                    userServiceVo.setClientId(response.getClientId());
                    userServiceVo.setServiceId((int) row.getCell(21).getNumericCellValue());
                    AddressVo addressVo = new AddressVo();
                    addressVo.setHouseNo((int) row.getCell(22).getNumericCellValue());
                    addressVo.setWrdNo((int) row.getCell(23).getNumericCellValue());
                    addressVo.setStreetName(row.getCell(24).getStringCellValue());
                    addressVo.setMunicipality(row.getCell(25).getStringCellValue());
                    addressVo.setDistrict(row.getCell(26).getStringCellValue());
                    addressVo.setZone(row.getCell(27).getStringCellValue());
                    addressVo.setCountry(row.getCell(28).getStringCellValue());
                    userServiceVo.setActive(row.getCell(29).getBooleanCellValue());
                    userServiceVo.setConnectedArea(row.getCell(30).getStringCellValue());
                    UserServicesResponse userServicesResponse = userServicesService.saveUserServices(userServiceVo, currentPrincipalName);
                } catch (PokharaInternetException e) {
                    return "redirect:/exception/error?q=" + e.getMessage();

                }
            }

        }
        return "redirect:/dashboard";
    }
}
