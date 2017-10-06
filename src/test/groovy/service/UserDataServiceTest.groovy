package com.pinet.app.service

import com.pinet.app.entities.UserDataEntity
import com.pinet.app.model.UserDataResponse
import com.pinet.app.model.UserDataVO
import com.pinet.app.repository.UserDataRepository
/**
 * Created by bijesh on 7/28/2017.
 */
class UserDataServiceTest extends spock.lang.Specification {

    UserDataRepository userDataRepository = Mock(UserDataRepository)

    UserDataService service = new UserDataService()

    def setup() {
        service.userDataRepository = userDataRepository
    }

    def "SaveUser"() {
        given:
        UserDataVO userDataVO = new UserDataVO()
        UserDataEntity userDataEntity = new UserDataEntity()
        userDataEntity.setCreatedBy("testData")


        when:
        def result = service.saveUser(userDataVO, "testData")
        result.getCreatedBy().equalsIgnoreCase("testData")

        then:
        result != null

        and:
         1* userDataRepository.save(*_) >> userDataEntity
    }

    def "GetAllUsers"() {
        given:
        List <UserDataEntity> userDataEntity=new ArrayList<>()

        when:
        def userDataList=service.getAllUsers()

        then:
        userDataList!=null

        and:
        1* userDataRepository.findAll() >>userDataEntity

    }


    def "GetUserById"() {

        given:
        UserDataEntity data = new UserDataEntity()

        when:
        def result=service.getUserById(1)

        then:
        result!=null

        and:
        1* userDataRepository.findOne(1) >>data

    }

    def "when DeleteUserById is called returns null"() {
        when:
        def result = service.deleteUserById(1)

        then:
        result == null

    }

    def "when DeleteUserById is called"() {

        given:
        UserDataEntity data = new UserDataEntity()
        when:
        def result = service.deleteUserById(1)

        then:
        result != null
        result.equalsIgnoreCase("User successfully deleted")

        and:
        1 * userDataRepository.findOne(1) >> data


    }

    def "UpdateUserById"() {
        given:
        UserDataEntity userDataEntity=new UserDataEntity()
        UserDataVO userDataVO=new UserDataVO()

        when:
        def result= service.updateUserById(userDataVO,1,"Ashmeet")

        then:
        result!=null

        and:
        1* userDataRepository.findOne(1) >> userDataEntity
        1* userDataRepository.save(userDataEntity) >> userDataEntity

    }

    def "UpdateUserById1"() {
    given:
    UserDataEntity userDataEntity=new UserDataEntity()
    UserDataVO userDataVO=new UserDataVO()

    when:
    def result= service.updateUserById(userDataVO,1,"Ashmeet")

    then:
    result!=null

    and:
    1* userDataRepository.findOne(1) >> userDataEntity
    1* userDataRepository.save(userDataEntity) >> userDataEntity

    }

//    def "stub testing"(){
//
//
//        given:
//        UserDataVO userDataVO=new UserDataVO()
//
//        userDataVO.setName("Tiwary")
//        userDataRepository1.save(userDataVO) >>>[userDataVO]
//
//
//        when:
//        def result=service.saveUser(userDataVO,"Ashmeet")
//
//        then:
//        result!=null
//    }

}
