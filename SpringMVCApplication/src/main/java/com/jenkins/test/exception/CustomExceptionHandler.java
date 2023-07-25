package com.jenkins.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Object> handleCourseNotFoundException(CourseNotFoundException ex)
 {
        // Create a custom error response
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", "Course not found");
        responseBody.put("message", ex.getMessage());
        
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}
