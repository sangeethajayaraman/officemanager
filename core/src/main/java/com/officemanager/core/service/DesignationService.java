package com.officemanager.core.service;

import com.officemanager.core.domain.Designation;

import java.util.List;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
public interface DesignationService {

    public Designation save(Designation designation);

    public Designation findById(Integer designationId);

    public List<Designation> findAll();
}
