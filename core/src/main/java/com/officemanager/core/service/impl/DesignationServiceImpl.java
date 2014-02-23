package com.officemanager.core.service.impl;

import com.officemanager.core.domain.Designation;
import com.officemanager.core.persistence.DesignationMapper;
import com.officemanager.core.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
@Service("designationService")
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationMapper designationMapper;

    public void setDesignationMapper(DesignationMapper designationMapper) {
        this.designationMapper = designationMapper;
    }

    @Override
    @Transactional
    public Designation save(Designation designation) {
        if (designation.getDesignationId() == null){
            designationMapper.insert(designation);
        }else{
            designationMapper.update(designation);
        }
        return designation;
    }

    @Override
    @Transactional(readOnly = true)
    public Designation findById(Integer designationId) {
        return designationMapper.findById(designationId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Designation> findAll() {
        return designationMapper.findAll();
    }
}
