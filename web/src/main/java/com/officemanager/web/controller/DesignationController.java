package com.officemanager.web.controller;

import com.officemanager.core.domain.Designation;
import com.officemanager.core.service.DesignationService;
import com.officemanager.web.model.Designations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
@Controller
@RequestMapping("/designations")
public class DesignationController {

    @Resource()
    DesignationService designationService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Designation> list(){
        return designationService.findAll();
    }

    public Designation find(Integer id){
        return new Designation();
    }

    public void create(Designation designation){

    }

    public void delete(Integer id){

    }

    public void update(Integer id, Designation designation){

    }
}
