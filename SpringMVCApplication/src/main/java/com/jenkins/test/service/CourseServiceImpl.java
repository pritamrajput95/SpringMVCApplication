package com.jenkins.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenkins.test.entity.Course;
import com.jenkins.test.exception.CourseNotFoundException;
import com.jenkins.test.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCoursebyId(long courseid) {
        System.out.println("courseid>>>>>>>>>"+courseid);
        return courseRepository.findById(courseid)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseid));
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(long courseid) {
        courseRepository.deleteById(courseid);
    }
}