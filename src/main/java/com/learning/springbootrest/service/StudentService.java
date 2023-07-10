package com.learning.springbootrest.service;

import com.learning.springbootrest.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAll();

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}
