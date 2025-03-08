package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {

}
