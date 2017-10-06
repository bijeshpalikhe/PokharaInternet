package com.pinet.app.model;

import com.pinet.app.entities.UserDataEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;


public class CustomUserDetails implements UserDetails {

    private UserDataEntity userDataEntity;

    public CustomUserDetails(UserDataEntity userDataEntity) {
        System.out.println("\n USER ROLES : " + userDataEntity.getRoles());
        this.userDataEntity = userDataEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        System.out.println("\n ROLES: " + userDataEntity.getRoles());
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        String roles = userDataEntity.getRoles();

        if (roles.contains(",")) {
            String[] parts = roles.split(",");
            String part1 = parts[0]; // 004
            String part2 = parts[1]; // 034556


            authorities.add(new SimpleGrantedAuthority(part1));
            authorities.add(new SimpleGrantedAuthority(part2));

            for (GrantedAuthority autho : authorities) {
                System.out.println("AUTHORITIES ARE : " + autho.getAuthority());
            }
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        System.out.println("PASSWORD : " + userDataEntity.getPassword());
        return userDataEntity.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("\n MIRACLE USERNAME : " + userDataEntity.getUsername());

        return userDataEntity.getUsername();
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
