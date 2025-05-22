package org.geeksforgeeks.crash_course_spring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="student")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id", nullable=false)
private long id;

@Column(name="first_name",nullable=false)
private String firstName;

@Column(name="last_name",nullable=false)
private String lastName;

//--- Getters and Setters ---

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}
}




