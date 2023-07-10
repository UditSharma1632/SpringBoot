package com.learning.springbootrest.service;

import com.learning.springbootrest.entity.Student;
import com.learning.springbootrest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepo;

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent= studentRepo.findById(id);
        return optionalStudent.get();
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepo.findById(student.getId()).get();
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBranch(student.getBranch());
        Student updatedStudent = studentRepo.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}
