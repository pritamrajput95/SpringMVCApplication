package com.jenkins.test.service;

import java.util.List;

import com.jenkins.test.entity.Course;

public interface CourseService {

	public List<Course> getCourses();

	public Course getCourse(long courseid);

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deletedCourse(long parseLong);
}
