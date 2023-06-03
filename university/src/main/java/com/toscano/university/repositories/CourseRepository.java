package com.toscano.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toscano.university.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
