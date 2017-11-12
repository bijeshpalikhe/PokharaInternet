package com.pinet.app.model;

import com.pinet.app.entities.EmployeeRolesEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;


public class CustomEmployeeInfoDetailsSecurity implements UserDetails {

    private EmployeeRolesEntity employeeRolesEntity;


    public CustomEmployeeInfoDetailsSecurity(EmployeeRolesEntity employeeRolesEntity) {
     //   System.out.println("\n USER ROLES : " + employeeRolesEntity.getRoles());
        this.employeeRolesEntity = employeeRolesEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        String roles = employeeRolesEntity.getRoles();

        if (roles.contains(",")) {
            String[] parts = roles.split(",");
            String part1 = parts[0]; // 004
            String part2 = parts[1]; // 034556


            authorities.add(new SimpleGrantedAuthority(part1));
            authorities.add(new SimpleGrantedAuthority(part2));
        } else {
            authorities.add(new SimpleGrantedAuthority(roles));
        }
        for (GrantedAuthority autho : authorities) {
            System.out.println("AUTHORITIES ARE : " + autho.getAuthority());
        }

        return authorities;

    }

    @Override
    public String getPassword() {
        return employeeRolesEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return employeeRolesEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}