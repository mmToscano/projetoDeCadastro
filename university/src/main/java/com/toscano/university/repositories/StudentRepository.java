package com.toscano.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toscano.university.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
