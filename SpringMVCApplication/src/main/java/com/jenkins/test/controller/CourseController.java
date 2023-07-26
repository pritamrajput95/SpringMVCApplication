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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.test.entity.Course;
import com.jenkins.test.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
    
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "this is home";
		
	}
	
	@GetMapping(value="/all")
	public List<Course> getCourses(){
		 System.out.println("get method call for all");
		return this.courseService.getCourses();
	}
	
	@GetMapping(value="/search",produces = {"application/json" })
	public Course getCoursebyId (@RequestParam("courseid") long courseid) {
		 System.out.println("get method call by id");
		return this.courseService.getCoursebyId(courseid);
	}
	
	@PostMapping(value="/add")
	public Course addCourse(@RequestBody Course course) {
		 System.out.println("add method call");
		return this.courseService.addCourse(course);
	}
	
	@PutMapping(value="/update")
	public Course updateCourse(@RequestBody Course course) {
	       System.out.println("update method call");
		return this.courseService.updateCourse(course);
	}
	
	/*
	 * @DeleteMapping(value="/delete/{courseid}") public ResponseEntity<HttpStatus>
	 * deleteCourse(@RequestParam("courseid") String courseId){ try {
	 * this.courseService.deletedCourse(Long.parseLong(courseId)); return new
	 * ResponseEntity<>(HttpStatus.OK); } catch (Exception e) { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */
	
	@DeleteMapping("/delete/{courseid}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseid") String courseid) {
        System.out.println("delete method call by id");
        long courseIdLong;
        try {
            courseIdLong = Long.parseLong(courseid);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid course ID format.", HttpStatus.BAD_REQUEST);
        }

        Course courseToDelete = courseService.getCoursebyId(courseIdLong);
        if (courseToDelete == null) {
            return new ResponseEntity<>("Course not found.", HttpStatus.NOT_FOUND);
        }

        courseService.deleteCourse(courseIdLong);
        return new ResponseEntity<>("Course deleted successfully.", HttpStatus.OK);
    }	
}