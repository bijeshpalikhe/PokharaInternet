package com.pinet.app.web.controller

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
//        def response = mockMvc.perform(get('/users')).andReturn().response
//     //   println("REsponse : "+response.getContentAsString())
//
//      // def content = new JsonSlurper().parseText(response.contentAsString)
//     //   println(content)
//
//
//        then: 'securityService correctly returned account in JSON'
//        1 * userDataController.getUsers()
//
//
//        response.status == OK.value()
//
//        //Showing how a contains test could work
//        response.contentType.contains('application/json')
//       // response.contentType == 'application/json;charset=UTF-8'
//

    }

    def "GetUsers"() {
//        given:
//        RestTemplate restTemplate=new RestTemplate()
//
//        when:
//        ResponseEntity responseEntity= restTemplate.getForObject("http://localhost:8080/userdata/users",ResponseEntity.class)
//
//        then:
//        responseEntity!=null
//
//        and:
//        print(responseEntity)




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
