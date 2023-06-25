package com.jenkins.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jenkins.test.entity.Course;

@Service
public class CourseServiceImpl implements  CourseService {

	// dao logic
	 List<Course> list; 
	//constructor
	public CourseServiceImpl() {
		 //create arraylist for adding 
		 list= new ArrayList<>();
		 list.add(new Course(101, "Java", "this is java course"));
		 list.add(new Course(102, "Spring", "this is a framework"));
	}
	
	@Override
	public List<Course> getCourses() {
	
	 
		return list;
	}


	@Override
	public Course getCourse(long courseid) {
		
		Course c=null;
		
		for(Course course:list) {
			
			if(course.getCourseId()==courseid) {
				c=course;
				break;
			}
		}
		
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		list.forEach(e->{
			if(e.getCourseId()==course.getCourseId()) {
			   e.setCourseName(course.getCourseName());
			   e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deletedCourse(long parseLong) {
		 System.out.println("delete method call");
		
		 //logic for delete course byid
		 list=this.list.stream().filter(e->e.getCourseId()!=parseLong).collect(Collectors.toList());
	}


	
}
