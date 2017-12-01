package service

import com.pinet.app.entities.EmployeeRolesEntity
import com.pinet.app.repository.EmployeeRolesRepository
import com.pinet.app.service.EmployeeRolesService
import spock.lang.Specification

class EmployeeRolesServiceTest extends spock.lang.Specification {
    EmployeeRolesRepository employeeRolesRepository = Mock( EmployeeRolesRepository)
    EmployeeRolesService service = new EmployeeRolesService()

    def setup() {
        service.employeeRolesRepository = employeeRolesRepository
    }

    void cleanup() {
    }

    def "SaveEmployeeRoles"() {
    }

    def "UpdateEmployeeRolesById"() {
    }

    def "DeleteEmployeeRolesById"() {
    }

    def "GetEmployeeRoles"() {
        given:
        EmployeeRolesEntity entity = new EmployeeRolesEntity()
        entity.setId(1)
        entity.setEmployeeId(101)
        entity.setUserName("Arjun")
        entity.setPassword("Pokhara")
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        entity.setRoles("Admin")
        entity.setCreatedBy ("Name")
        entity.setCreatedDate (sqlDate)
        entity.setLastModifiedBy("Name")
        entity.setLastModifiedDate(sqlDate)



        entity.add(entity)


        when:
        def result = service.getEmployeeRoles(1)

        then:
        result != null
        result.employeeId==1




        and:
        1 * employeeRolesRepository.findOne(id: 1) >> entity
    }

}
