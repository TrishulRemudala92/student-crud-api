package org.geeksforgeeks.crash_course_spring.service;

import java.util.*;

import org.geeksforgeeks.crash_course_spring.entities.Student;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
 
	@Autowired
	public StudentService(StudentRepository studentRepository){
		
		this.studentRepository=studentRepository;

}
	public Student addStudent(Student student) {
		/*Student addedStudent =this.studentRepository.save(student);
		return addedStudent;*/
		return this.studentRepository.save(student);

	}
	public Student getStudentById(long studentId) {
		Optional<Student> optionalValue=this.studentRepository.findById(studentId);
		return optionalValue.orElse(null);	
		
	}
	public void deleteStudentById(long studentId) {
		this.studentRepository.deleteById(studentId);
	}
}