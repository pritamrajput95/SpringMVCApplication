package com.jenkins.test.entity;

public class Course {

	private long courseId;
	private String courseName;
	private String description;
	public Course(long courseId, String courseName, String description) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description + "]";
	}
	
	
}
