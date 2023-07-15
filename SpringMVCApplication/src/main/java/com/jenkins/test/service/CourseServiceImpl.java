package com.jenkins.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenkins.test.entity.Course;
import com.jenkins.test.repository.CourseRepository;

@Service
public class CourseServiceImpl implements  CourseService {

	// dao logic
	
	@Autowired
	CourseRepository courseRepository;
	
	//constructor
	public CourseServiceImpl() {
	
	}
	
	@Override
	public List<Course> getCourses() {
	
	 
		return courseRepository.findAll();
	}


	@Override
	public Course getCourse(long courseid) {
		
		
		return courseRepository.getOne(courseid);
	}


	@Override
	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
	   
		courseRepository.save(course);
		
		return course;
	}

	@Override
	public void deletedCourse(long parseLong) {
		 System.out.println("delete method call");
		
		 Course entityCourse= courseRepository.getOne(parseLong);
		 
		 courseRepository.delete(entityCourse);
	
	}


	
}
