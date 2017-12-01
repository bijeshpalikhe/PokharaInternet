package service

import com.pinet.app.entities.ServiceTypeEntity
import com.pinet.app.repository.ServiceTypeRepository
import com.pinet.app.service.ServiceTypeService
import spock.lang.Specification

class ServiceTypeServiceTest extends spock.lang.Specification {
    ServiceTypeRepository serviceTypeRepository =Mock(ServiceTypeRepository)
    ServiceTypeService service = new  ServiceTypeService()

    def setup() {
        service.serviceTypeRepository = serviceTypeRepository
    }

    def cleanup() {
    }

    def "SaveServiceType"() {
    }

    def "GetServiceType"() {
        given:

        List<ServiceTypeEntity> data = new ArrayList<>()
        ServiceTypeEntity entity = new ServiceTypeEntity()
        entity.setId(1)
        entity.setService("Wireless")
        entity.setBandwidth("5")


        data.add(entity)

        when:
        def result = service.getServiceType()

        then:
        result != null
        result.size() == 1


        and:
        1 * serviceTypeRepository.findAll() >> data
    }

    def "GetServiceTypeByServiceType"() {
    }

    def "GetServiceTypeByBandwidth"() {
    }
}
