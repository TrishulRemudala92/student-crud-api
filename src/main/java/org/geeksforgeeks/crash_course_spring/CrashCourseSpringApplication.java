package org.geeksforgeeks.crash_course_spring;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	    "org.geeksforgeeks.crash_course_spring",
	    "org.geeksforgeeks.crash_course_spring_controllers"
	})

public class CrashCourseSpringApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(CrashCourseSpringApplication.class, args);
	}
		
}

