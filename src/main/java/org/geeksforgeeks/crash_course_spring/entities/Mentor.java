package org.geeksforgeeks.crash_course_spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="mentor")
public class Mentor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id",nullable=false)
	private long id;
	
	@Column(name="firstName",nullable=false)
	@NotBlank	
	private String firstName;
	
	@Column(name="lastName",nullable=false)
	@NotBlank
	private String lastName;
	
	@Column(name="currentCompany",nullable=false)
	@NotBlank
	private String currentCompany;
	
	@Column(name="yearsofExperience", nullable=false)
	@Min(0)
	@Max(40)
	private float yearsofExperience;

	// No-arg constructor required by JPA
    public Mentor() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =lastName;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public float getYearsofExperience() {
        return yearsofExperience;
    }

    public void setYearsofExperience(float yearsofExperience) {
        this.yearsofExperience = yearsofExperience;
    }
}
