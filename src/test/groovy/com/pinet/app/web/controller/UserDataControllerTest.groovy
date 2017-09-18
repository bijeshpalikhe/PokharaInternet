package com.pinet.app.web.controller

import com.pinet.app.entities.UserDataEntity
import com.pinet.app.service.UserDataService
import groovy.json.JsonSlurper
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.http.HttpStatus.*
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class UserDataControllerTest extends Specification {

UserDataController userDataController=new UserDataController()
    def userDataService=Mock(UserDataService)


    MockMvc mockMvc = standaloneSetup(UserDataController).build()

    def setup(){
        userDataController.userDataService=userDataService
    }


    def "getAccount test hits the URL and parses JSON output"() {
//        when: 'rest account url is hit'
//        def response = mockMvc.perform(get('/rest/account')).andReturn().response
//        def content = new JsonSlurper().parseText(response.contentAsString)
//
//        then: 'securityService correctly returned account in JSON'
//        1 * securityService.getCurrentLogin() >> 'spockUser'
//
//        //Testing the HTTP Status code
//        response.status == OK.value()
//
//        //Showing how a contains test could work
//        response.contentType.contains('application/json')
//        response.contentType == 'application/json;charset=UTF-8'
//
//        //Can test the whole content string that is returned
//        response.contentAsString == '{"username":"spockUser"}'
//
//        //Or can use the JsonSlurper version to test the JSON as object
//        content.username == 'spockUser'

    }

    def "GetUsers"() {
//        given:
//        RestTemplate restTemplate=new RestTemplate()
//
//        when:
//       UserDataEntity []userDataEntity= restTemplate.getForObject("http://localhost:8080/userdata/users",UserDataEntity[].class)
//
//        then:
//        userDataEntity!=null
//
////        and:
////        print(userDataEntity)




    }

    def "GetUserById"() {
    }

    def "DeleteUserById"() {
    }

    def "SaveUserData"() {
    }

    def "UpdateUserData"() {
    }
}
