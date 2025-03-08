package com.app.jdbc.smartrecruit.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {}

}
