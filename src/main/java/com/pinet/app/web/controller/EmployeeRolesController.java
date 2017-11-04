package com.pinet.app.web.controller;

import com.pinet.app.model.EmployeeInfoResponse;
import com.pinet.app.model.EmployeeInfoVO;
import com.pinet.app.model.EmployeeRolesVo;
import com.pinet.app.service.EmployeeInfoService;
import com.pinet.app.service.EmployeeRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/employeeroles")
public class EmployeeRolesController {
    @Autowired
    EmployeeRolesService employeeRolesService;



    //    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", value = "/roles/{employeeId}")
    public ResponseEntity saveEmployeeInfo(@RequestBody EmployeeRolesVo employeeRolesVo,@PathVariable("employeeId") Integer employeeId, @RequestParam(value="employeeName") String employeeName) {
        try {

            return ResponseEntity.ok(employeeRolesService.saveEmployeeRoles(employeeRolesVo,employeeId,employeeName));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }


    }

}