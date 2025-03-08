package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    private String domain;

    public Employee() {}

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
