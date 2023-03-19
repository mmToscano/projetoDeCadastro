package br.com.projetoFullStack.projetoFull.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFullStack.projetoFull.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
