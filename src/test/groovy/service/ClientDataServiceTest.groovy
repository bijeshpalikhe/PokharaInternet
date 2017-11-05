package com.pinet.app.service

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
