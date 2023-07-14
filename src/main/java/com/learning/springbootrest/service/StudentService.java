package com.learning.springbootrest.service;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto student);

    StudentDto getStudentById(Long id);

    List<StudentDto> getAll();

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
