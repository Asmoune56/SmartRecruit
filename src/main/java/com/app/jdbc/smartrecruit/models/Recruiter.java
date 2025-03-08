package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RECRUITER")
public class Recruiter extends User{
    private String companyName;

    public Recruiter() {
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
