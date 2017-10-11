//package com.pinet.app.service;
//
//import com.pinet.app.entities.UserDataEntity;
//import com.pinet.app.model.CustomUserDetails;
//import com.pinet.app.repository.UserDataRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserDataRepository userDataRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("the typed username is : "+username);
//        UserDataEntity userDataEntity=userDataRepository.findByUsername(username);
//        if(userDataEntity==null){
//            System.out.println("\n\n Username is null \n");
//            throw new UsernameNotFoundException("USer Not Found");
//        }
//        System.out.println("\n USERNAME IS NOT NULL : "+userDataEntity.getEmail());
//        return new CustomUserDetails(userDataEntity);
//    }
//}