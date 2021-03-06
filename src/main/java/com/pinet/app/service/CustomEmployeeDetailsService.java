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
        System.out.println("the typed username is : "+username);
        EmployeeRolesEntity employeeRolesEntity=employeeRolesRepository.findByUsername(username);
        if(employeeRolesEntity==null){
            System.out.println("\n\n Username is null \n");
            throw new UsernameNotFoundException("Employee cannot be found Not Found");
        }
        System.out.println("\n USERNAME IS NOT NULL : "+employeeRolesEntity.getPassword());
        return new CustomEmployeeInfoDetailsSecurity(employeeRolesEntity);
    }
}