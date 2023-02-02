package br.com.projetoFullStack.projetoFull.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoFullStack.projetoFull.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
