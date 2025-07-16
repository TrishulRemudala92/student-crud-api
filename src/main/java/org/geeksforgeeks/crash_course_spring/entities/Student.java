package org.geeksforgeeks.crash_course_spring.entities;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


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
@NotBlank(message="First Name must not be null")
private String firstName;

@Column(name="last_name",nullable=false)
@NotBlank
private String lastName;

@Column(name="email", nullable=false, unique=true)
@NotBlank(message ="Email is required")
private String email;

@Column(name="password", nullable=false)
private String password;


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

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}






