package org.geeksforgeeks.crash_course_spring_controllers;

import org.geeksforgeeks.crash_course_spring.entities.Course;
import org.geeksforgeeks.crash_course_spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	private final CourseService courseService;
	
	@Autowired
	public CourseController(CourseService courseService)
{
		this.courseService=courseService;	
}
	@PostMapping("/add")
	public ResponseEntity<?> addCourse(@RequestBody @Valid Course course) {
	return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);
	}
}
