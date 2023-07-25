package com.jenkins.test.exception;

public class CourseNotFoundException  extends RuntimeException{

	public CourseNotFoundException(String message) {
		
		super(message);
	}
	
	
}
