package com.officemanager.web.controller;

import com.officemanager.core.domain.Designation;
import com.officemanager.core.service.DesignationService;
import org.junit.Before;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
public class DesignationControllerIntegrationTest extends BaseControllerTest{

    @Before
    public void setup(){
        super.setup();

        //Though spring provides a way to configure a mock bean in the app context, you still need to define behaviour
        //on the mock object. I have not found a better way to do it yet.
        DesignationService designationService = webApplicationContext.getBean(DesignationService.class);

        List<Designation> designationList = new ArrayList<>();
        Designation designation = new Designation();
        designation.setDesignationId(1);
        designation.setName("Sales Executive");
        designationList.add(designation);

        designation = new Designation();
        designation.setDesignationId(2);
        designation.setName("Chief Technology Officer");
        designationList.add(designation);

        when(designationService.findAll()).thenReturn(designationList);
    }

    @Test
    public void listDesignations() throws Exception{
        mockMvc.perform(get("/designations"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Sales Executive"));

    }
}
