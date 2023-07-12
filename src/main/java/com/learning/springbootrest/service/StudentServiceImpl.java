package com.learning.springbootrest.service;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;
import com.learning.springbootrest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepo;

    ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = modelMapper.map(studentDto, Student.class);

        Student savedStudent = studentRepo.save(student);

        StudentDto updatedStudentDto = modelMapper.map(savedStudent, StudentDto.class);

        return updatedStudentDto;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> optionalStudent= studentRepo.findById(id);
        Student student = optionalStudent.get();
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepo.findAll();
        return students.stream().map((student -> modelMapper.map(student, StudentDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto student) {
        Student existingStudent = studentRepo.findById(student.getId()).get();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBranch(student.getBranch());
        Student updatedStudent = studentRepo.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
