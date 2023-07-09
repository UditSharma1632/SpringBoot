package com.learning.springbootrest.repository;

import com.learning.springbootrest.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // here Student is jpa entity and long is primary key
}
