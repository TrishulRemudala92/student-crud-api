package org.geeksforgeeks.crash_course_spring.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
 
 @Column(name="price", nullable=false)
 @Min(0)
 private double price;
 
 @Column(name="capacity", nullable=false)
 @Min(10)
 private int capacity;
 
 @Column(name="no_of_days", nullable=false)
 @Min(5)
 @Max(60)
 private int noOfDays;
 
 @Column(name="start_date",nullable=false)
 private LocalDateTime startDate;
 
 @Column(name="description")
 private String description;
 
 
 @OneToMany
 @JoinColumn(name="mentor_id", nullable=false)
 private Mentor mentor;
 
 @Column(name="enrolment_ened_date",nullable=false)
 private LocalDateTime enrolmentEndDate;
 
 public LocalDateTime getEndDate() {

      return this.startDate.plusDays(this.noOfDays);

   
 }

 
}
