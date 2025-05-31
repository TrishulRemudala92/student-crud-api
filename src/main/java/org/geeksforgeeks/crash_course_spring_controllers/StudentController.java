package org.geeksforgeeks.crash_course_spring_controllers;

import java.util.Map;

import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.geeksforgeeks.crash_course_spring.service.StudentService;
import org.geeksforgeeks.crash_course_spring_exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")

public class StudentController {

	private final StudentRepository studentRepository;
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService, StudentRepository studentRepository) {
		this.studentService = studentService;
		this.studentRepository = studentRepository;
	}

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody @Valid Student student) {
		try {
			return ResponseEntity.ok(this.studentService.addStudent(student));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
		}
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable(name = "studentId") long studentId) {
		try {
			Student student = this.studentService.getStudentById(studentId);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
		}
	}


	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable long studentId, @RequestBody Student student) {
		try {
			if (studentId != student.getId()) {
				return ResponseEntity.badRequest()
						.body(Map.of("message", "The ID in the path and the body are not same"));
			}
			Student updatedStudent = this.studentService.UpdateStudent(student);
			return ResponseEntity.ok(updatedStudent);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
		}
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable long studentId) {
		try {
			this.studentService.deleteStudentById(studentId);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
		}

	}
}
