package com.officemanager.core.persistence

import spock.lang.Specification

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration

import com.officemanager.core.domain.Designation
import com.officemanager.core.service.DesignationService


@ContextConfiguration(locations = ["classpath:/integration-test-resources.xml", "classpath:/applicationContext-persistence.xml",
"classpath:/applicationContext-service.xml"])
class DesignationServiceIntegrationTest extends Specification{

    @Autowired
    DesignationService designationService

    def "should find all existing records"(){
        given: "existing record in the database"
        createDesignationRecord()

        when:
        def designations = designationService.findAll()

        then:
        designations.size() == 1
    }

    def "should update an existing record "(){
        given: "an existing designation record"
        Designation designation = createDesignationRecord()

        when: "the designation is updated"
        designation.setName("Junior Developer")
        designation = designationService.save(designation)

        then: "the field in the database should contain the updated value"
        designation.getName() == "Junior Developer"
    }

    def "should find an existing record by id"(){
        given: "an existing designation record"
        Designation designation = createDesignationRecord()

        when:
        Designation foundDesignation = designationService.findById(designation.designationId)

        then:
        designation.getDesignationId() == foundDesignation.getDesignationId()
    }

    def Designation createDesignationRecord(){
        Designation designation = new Designation()
        designation.setName("Senior Developer")
        designation.setDescription("Develops software using java")
        //Save
        designation = designationService.save(designation)
        return designation;
    }
}
