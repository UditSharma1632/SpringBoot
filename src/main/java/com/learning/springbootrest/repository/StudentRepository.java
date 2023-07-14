package com.learning.springbootrest.repository;

import com.learning.springbootrest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // here Student is jpa entity and long is primary key
    Optional<Student> findByEmail(String email);
}
