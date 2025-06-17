package org.geeksforgeeks.crash_course_spring.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course")
@NoArgsConstructor
@Getter
@Setter
public class Course {
 @Id
 @GeneratedValue(strategy= GenerationType.SEQUENCE)
 @Column(name="id", nullable=false)
 private long id;
 
 @Column(name="name", nullable=false)
 private String name;
 
 //Getters and Setters for name
 
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 @Column(name="price", nullable=false)
 @Min(0)
 private double price;
 
 @Column(name="capacity", nullable=false)
 @Min(10)
 private int capacity;
 
 public int getCapacity() {
	    return capacity;
	}

 
 @Column(name="no_of_days", nullable=false)
 @Min(5)
 @Max(60)
 private int noOfDays;
 
 //Getters and Setters for noOfDays
 
 public int getNoOfDays() {
	    return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
	    this.noOfDays = noOfDays;
	}

 
 @Column(name="start_date",nullable=false)
 private LocalDateTime startDate;
 
 //Getters and Setters
 public LocalDateTime getStartDate() {
     return startDate;
 }

 public void setStartDate(LocalDateTime startDate) {
     this.startDate = startDate;
 }

 
 @Column(name="description")
 private String description;
 
 
 @ManyToOne
 @JoinColumn(name="mentor_id", nullable=false)
 private Mentor mentor;
 
 //Getter and Setters
 
 public Mentor getMentor() {
	    return mentor;
	}
 
 public void setMentor(Mentor mentor) {
	    this.mentor = mentor;
	}
 
 @Column(name="enrolment_end_date",nullable=false)
 private LocalDateTime enrolmentEndDate;
 
 //Getters and Setters for enrolment_end_date
 
 public LocalDateTime getEnrolmentEndDate() {
	    return enrolmentEndDate;
	}

	public void setEnrolmentEndDate(LocalDateTime enrolmentEndDate) {
	    this.enrolmentEndDate = enrolmentEndDate;
	}
 
 public LocalDateTime getEndDate() {

      return this.startDate.plusDays(this.noOfDays);

    
 }

 
}
