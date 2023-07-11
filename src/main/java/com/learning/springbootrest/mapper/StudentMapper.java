package com.learning.springbootrest.mapper;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;

// This class will map dto objects
public class StudentMapper {

    // We will use this method to map StudentDto to Student
    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getBranch());
        return student;
    }

    // We will use this method to map Student to StudentDto
    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto(student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBranch());
        return studentDto;
    }
}
