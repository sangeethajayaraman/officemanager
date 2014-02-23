package com.officemanager.core.domain;

import com.google.common.base.Objects;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */
public class Designation {

    private Integer designationId;
    private String name;
    private String description;
    private Integer reportTo;

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReportTo() {
        return reportTo;
    }

    public void setReportTo(Integer reportTo) {
        this.reportTo = reportTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Designation designation = (Designation) o;

        if (designationId != null ? !designationId.equals(designation.designationId) : designation.designationId != null) return false;
        if (name != null ? !name.equals(designation.name) : designation.name != null) return false;
        if (description != null ? !description.equals(designation.description) : designation.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(designationId, name, description);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", designationId)
                .add("name", name)
                .add("description", description)
                .toString();
    }
}
