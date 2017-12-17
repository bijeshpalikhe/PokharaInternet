package com.pinet.app.service

import com.pinet.app.entities.ClientDataEntity
import com.pinet.app.model.ClientDataVO
import com.pinet.app.model.ClientVO
import com.pinet.app.repository.ClientDataRepository

/**
 * Created by bijesh on 11/5/2017.
 */
class ClientDataServiceTest extends spock.lang.Specification {
    ClientDataRepository clientDataRepository = Mock(ClientDataRepository)

    ClientDataService service = new ClientDataService()

    def setup() {
        service.clientDataRepository = clientDataRepository
    }

    def "SaveUser"() {

    }

    def "GetAllClients"() {
        given:
        List<ClientDataEntity> data = new ArrayList<>()
        ClientDataEntity entity = new ClientDataEntity()
        entity.setClientId(1)
        entity.setUserName("testName")
        entity.setClientName("{\"firstName\":\"bijesh\",\"middleName\":\"shankar\",\"lastName\":\"palikhe\"}")
        entity.setClientData("{\"gender\":\"M\",\"nationality\":\"Nepali\",\"citizenNo\":\"565653565\",\"passportNo\":\"102154554\",\"fatherName\":\"bishwo\",\"occupationType\":\"Self-emplopyed\"}")
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        entity.setDob(sqlDate)
        entity.setEmail("email")
        entity.setAddress("{\"houseNo\":1,\"streetName\":\"hamaltole\",\"municipality\":\"Pokhara-lekhnath\",\"district\":\"kaski\",\"zone\":\"gandaki\",\"country\":\"nepal\",\"wardNo\":4}")
        entity.setMobileNo("8888")
        entity.setPhoneNo("78888")

        data.add(entity)


        when:
        def result = service.getAllClients()

        then:
        result != null
        result.size() == 1


        and:
        1 * clientDataRepository.findAll() >> data


    }

    def "ConvertNametojson"() {

    }

    def "ConvertAddresstojson"() {

    }

    def "ConvertDatatojson"() {
        given:
        ClientDataVO clientVO = new ClientDataVO()
        when:
        def result = service.convertDatatojson(clientVO)

        then:
        result != null

    }

    def "ConvertClientEntityToResponse"() {

    }

    def "ConvertJsonToAddress"() {

    }

    def "ConvertJsonToName"() {

    }

    def "ConvertJsonToData"() {

    }

    def "SaveClientEntity"() {

    }
}
