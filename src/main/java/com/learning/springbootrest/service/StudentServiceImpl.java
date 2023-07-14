package com.learning.springbootrest.service;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;
import com.learning.springbootrest.exception.EmailAlreadyExistsException;
import com.learning.springbootrest.exception.ResourceNotFoundException;
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

        Optional<Student> optionalStudent = studentRepo.findByEmail(studentDto.getEmail());
        if (optionalStudent.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists");
        }
        Student student = modelMapper.map(studentDto, Student.class);

        Student savedStudent = studentRepo.save(student);

        StudentDto updatedStudentDto = modelMapper.map(savedStudent, StudentDto.class);

        return updatedStudentDto;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id" , id));
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

        Student existingStudent = studentRepo.findById(student.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student" , "id", student.getId()));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        Optional<Student> optionalStudent = studentRepo.findByEmail(student.getEmail());
        if (optionalStudent.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists");
        } else {
            existingStudent.setEmail(student.getEmail());
        }

        existingStudent.setBranch(student.getBranch());

        Student updatedStudent = studentRepo.save(existingStudent);

        return modelMapper.map(updatedStudent, StudentDto.class);

    }

    @Override
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        studentRepo.deleteById(id);
    }
}
