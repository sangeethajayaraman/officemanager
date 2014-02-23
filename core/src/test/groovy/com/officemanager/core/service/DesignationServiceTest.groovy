package com.officemanager.core.service

import spock.lang.Specification
import com.officemanager.core.persistence.DesignationMapper
import com.officemanager.core.domain.Designation
import com.officemanager.core.service.DesignationService
import com.officemanager.core.service.impl.DesignationServiceImpl
/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
class DesignationServiceTest extends Specification{
    DesignationServiceImpl designationService = new DesignationServiceImpl();

    def "should do insert if designationId is null otherwise do update"(){
        given:
        DesignationMapper dao = Mock()
        designationService.setDesignationMapper(dao)
        Designation designation = new Designation()

        when:
        designation.setDesignationId(null)
        designationService.save(designation)

        then:
        1 * dao.insert(designation)
        0 * dao.update(designation)

        when:
        designation.setDesignationId(1)
        designationService.save(designation)

        then:
        0 * dao.insert(designation)
        1 * dao.update(designation)
    }
}
