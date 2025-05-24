package org.geeksforgeeks.crash_course_spring_controllers;

import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.geeksforgeeks.crash_course_spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentController {

    private final StudentRepository studentRepository;
	private final StudentService studentService;
	
	@Autowired 
	public StudentController(StudentService studentService, StudentRepository studentRepository) {
		this.studentService=studentService;
		this.studentRepository = studentRepository;
	}
	@PostMapping("/add")
	public Student addStudent(@Validated @RequestBody Student student) {
	//System.out.println("RECEIVED: " + student.getFirstName() + " | " + student.getLastName());
		return this.studentService.addStudent(student);
	}
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable(name="studentId") long studentId) {	
	return this.studentService.getStudentById(studentId);
		
	} 
	
	@PutMapping("/{studentId}") 
	public Student updateStudent(@PathVariable long studentId, @RequestBody Student student) {
		if(studentId != student.getId()) {
			//Throw some error
		}
		return this.studentService.UpdateStudent(student);
	}
	
	@DeleteMapping("/{studentId}")
	public void deleteStudentById(@PathVariable long studentId) {
	this.studentService.deleteStudentById(studentId);
		
		
	}
	
}

