package com.pinet.app.service;


import com.pinet.app.entities.EmployeeRolesEntity;
import com.pinet.app.model.CustomEmployeeInfoDetailsSecurity;
import com.pinet.app.repository.EmployeeRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRolesRepository employeeRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeRolesEntity employeeRolesEntity=employeeRolesRepository.findByUsername(username);
        if(employeeRolesEntity==null){
            throw new UsernameNotFoundException("Employee cannot be found Not Found");
        }
        return new CustomEmployeeInfoDetailsSecurity(employeeRolesEntity);
    }
}