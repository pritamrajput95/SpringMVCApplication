package com.jenkins.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.test.entity.Course;
import com.jenkins.test.service.CourseService;

@RestController
public class MyController {
    
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "this is home";
		
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		 System.out.println("get method call for all");
		return this.courseService.getCourses();
	}
	
	@GetMapping("/course/{courseid}")
	public Course getCourse (@PathVariable String courseid) {
		 System.out.println("get method call by id");
		return this.courseService.getCourse(Long.parseLong(courseid));
	}
	
	//@PostMapping(path = "/courses",consumes ="application/json")
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		 System.out.println("add method call");
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
	       System.out.println("update method call");
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
		this.courseService.deletedCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	}
}