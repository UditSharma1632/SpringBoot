package com.learning.springboot.rest.service;

import com.learning.springboot.rest.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto student);

    StudentDto getStudentById(Long id);

    List<StudentDto> getAll();

    StudentDto updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
