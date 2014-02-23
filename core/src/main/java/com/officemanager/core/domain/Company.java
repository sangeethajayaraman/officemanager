package com.officemanager.core.domain;

import com.google.common.base.Objects;

/**
 * @author <a href="mailto:koolrich@gmail.com">Richard Nduka</a>
 */

public class Company {
    private Integer companyId;
    private String name;
    private String phone;
    private String website;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (address1 != null ? !address1.equals(company.address1) : company.address1 != null) return false;
        if (address2 != null ? !address2.equals(company.address2) : company.address2 != null) return false;
        if (city != null ? !city.equals(company.city) : company.city != null) return false;
        if (companyId != null ? !companyId.equals(company.companyId) : company.companyId != null) return false;
        if (email != null ? !email.equals(company.email) : company.email != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (phone != null ? !phone.equals(company.phone) : company.phone != null) return false;
        if (postalCode != null ? !postalCode.equals(company.postalCode) : company.postalCode != null) return false;
        if (website != null ? !website.equals(company.website) : company.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(companyId, name, phone, website, email, address1, address2, city, postalCode);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("companyId", companyId)
                .add("name", name)
                .add("phone", phone)
                .add("website", website)
                .add("email", email)
                .add("address1", address1)
                .add("address2", address2)
                .add("city", city)
                .add("postalCode", postalCode)
                .toString();
    }
}
