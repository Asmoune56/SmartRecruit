package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    private String domain;
    @ManyToOne
    @JoinColumn(name = "attachedOffer",unique = true)
    private Offer attachedOffer;

    public Employee() {}
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public Offer getAttachedOffer() {
        return attachedOffer;
    }
    public void setAttachedOffer(Offer attachedOffer) {
        this.attachedOffer = attachedOffer;
    }
}
