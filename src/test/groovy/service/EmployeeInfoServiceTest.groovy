package service


import com.pinet.app.model.EmployeeInfoResponse
import com.pinet.app.repository.EmployeeInfoRepository
import com.pinet.app.service.EmployeeInfoService
import spock.lang.Specification

class EmployeeInfoServiceTest extends spock.lang.Specification {
    EmployeeInfoRepository employeeInfoRepository= Mock(EmployeeInfoRepository)
    EmployeeInfoService service = new EmployeeInfoService()
    void setup() {
        service.employeeInfoRepository = employeeInfoRepository()
    }

    void cleanup() {
    }

    def "SaveEmployeeInfo"() {
    }

    def "GetEmployeeID"() {
    }

    def "GetAllEmployee"() {
        given:
        List<EmployeeInfoResponse> data = new ArrayList<>()
        EmployeeInfoResponse entity = new   EmployeeInfoResponse()
        entity.setEmployeeId(101)
        entity.setPhoneNo("9807654")
        entity.setEmail("email")
        entity.setInfo("This is your information")
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        entity.setDob(sqlDate)
        entity. setIdType("admin")
        entity.setIdNo("100")
        entity. setFileNo("200")
        entity.setEmployeesName("Ram")
        entity.setCreatedBy("Name")
        entity.setCreatedDate(sqlDate)
        entity.setLastModifiedBy("Name")
        entity.setLastModifiedDate(sqlDate)

        data.add(entity)

        when:
        def result = service.getAllEmployee()

        then:
        result != null
        result.size() == 1


        and:
        1 *  employeeInfoRepository.findAll() >> data

    }

    def "UpdateEmployeeInfoById"() {
    }

    def "DeleteEmployeeById"() {
    }

    def "ConvertInfoToString"() {
    }

    def "ConvertStringToInfo"() {
    }

    def "ConvertNameToString"() {
    }

    def "ConvertStringToName"() {
    }
}
