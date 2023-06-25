package com.jenkins.test.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jenkins.test.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course,Long>{

}
