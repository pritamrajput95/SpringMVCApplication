package com.jenkins.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenkins.test.Dao.CourseDao;
import com.jenkins.test.entity.Course;

@Service
public class CourseServiceImpl implements  CourseService {

	// dao logic
	
	@Autowired
	CourseDao courseDao;
	
	//constructor
	public CourseServiceImpl() {
	
	}
	
	@Override
	public List<Course> getCourses() {
	
	 
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseid) {
		
		
		return courseDao.getOne(courseid);
	}


	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
	   
		courseDao.save(course);
		
		return course;
	}

	@Override
	public void deletedCourse(long parseLong) {
		 System.out.println("delete method call");
		
		 Course entityCourse= courseDao.getOne(parseLong);
		 
		 courseDao.delete(entityCourse);
	
	}


	
}
