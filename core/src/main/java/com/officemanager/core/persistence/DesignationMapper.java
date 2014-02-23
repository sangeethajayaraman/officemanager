package com.officemanager.core.persistence;

import com.officemanager.core.domain.Designation;

import java.util.List;

/**
 *  Mapper class for Position
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */

public interface DesignationMapper {

    public void insert(Designation designation);

    public void update(Designation designation);

    public Designation findById(Integer designationId);

    public List<Designation> findAll();
}
