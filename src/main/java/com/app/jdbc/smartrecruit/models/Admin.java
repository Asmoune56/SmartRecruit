package com.app.jdbc.smartrecruit.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.sql.Date;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
    private java.sql.Date birthdate;

//    public Admin(java.sql.Date birthdate){
//        super();
//        this.birthdate = birthdate;
//
//    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
