package com.toscano.university.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toscano.university.entities.StudentClass;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer>{

}
