/*
package com.pinet.app.service

import com.pinet.app.entities.UserDataEntity
import com.pinet.app.repository.UserDataRepository
import org.mockito.Mock

*/
/**
 * Created by bijesh on 7/28/2017.
 *//*

class UserDataServiceTest extends spock.lang.Specification {

    UserDataRepository userDataRepository = Mock(UserDataRepository)

    UserDataService service = new UserDataService()

    def setup() {
        service.userDataRepository = userDataRepository
    }

    def "SaveUser"() {

    }

    def "GetAllUsers"() {

    }

    def "GetUserById"() {

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

    }

    def "UpdateUserById1"() {

    }

}
*/
