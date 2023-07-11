package com.learning.springbootrest.service;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;
import com.learning.springbootrest.mapper.StudentMapper;
import com.learning.springbootrest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepo;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);

        Student savedStudent = studentRepo.save(student);

        StudentDto updatedStudentDto = StudentMapper.mapToStudentDto(savedStudent);

        return updatedStudentDto;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> optionalStudent= studentRepo.findById(id);
        Student student = optionalStudent.get();
        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student existingStudent = studentRepo.findById(student.getId()).get();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBranch(student.getBranch());
        Student updatedStudent = studentRepo.save(existingStudent);
        StudentDto updatedStudentDto = StudentMapper.mapToStudentDto(updatedStudent);
        return updatedStudentDto;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
