package com.officemanager.web.model;

import com.officemanager.core.domain.Designation;

import java.io.Serializable;
import java.util.List;

/**
 * Used to support JSON generation for Designations
 *
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
public class Designations implements Serializable {

    private List<Designation> designations;

    public Designations() {
    }

    public Designations(List<Designation> designations) {
        this.designations = designations;
    }

    public List<Designation> getDesignations() {
        return designations;
    }
}
