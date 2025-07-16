package org.geeksforgeeks.crash_course_spring_exceptions;

public class NotFoundException extends RuntimeException{
	public NotFoundException (String message) {
		super(message);
	}

}
