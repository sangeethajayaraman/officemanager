package com.officemanager.web.controller

import com.officemanager.core.domain.Designation
import com.officemanager.core.service.DesignationService
import com.officemanager.web.model.Designations

import org.springframework.test.util.ReflectionTestUtils

import spock.lang.Specification


/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
class DesignationControllerTest extends Specification{

    def DesignationService mockDesignationService;
    def designationController = new DesignationController();

    def setup(){
        mockDesignationService = Mock(DesignationService.class)
        ReflectionTestUtils.setField(designationController, "designationService", mockDesignationService);
    }

    def "should get a list of all available designations"(){
        given:
        def designationList = [new Designation(designationId: 1, name: "Sales Executive"),
                new Designation(designationId: 2, name: "Tester")]

        when:
        def designationsWrapper = designationController.list()

        then:
        1 * mockDesignationService.findAll() >> designationList
        designationsWrapper.size() == designationList.size()
        designationsWrapper[0].name == "Sales Executive"
    }
}
