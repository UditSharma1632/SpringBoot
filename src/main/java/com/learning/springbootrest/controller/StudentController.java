package com.learning.springbootrest.controller;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.entity.Student;
import com.learning.springbootrest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("students")
public class StudentController {

    StudentService studentService;

    // post request using dto object
    @PostMapping("create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // get method using dto object

    @GetMapping("get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id){
       StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    // get method using dto object
    @GetMapping("get")
    public ResponseEntity<StudentDto> getStudentByParam(@RequestParam Long id){
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    // get method to obtain every user from db
    @GetMapping("getAll")
    public ResponseEntity<List<StudentDto>> getStudents(){
        List<StudentDto> studentDto = studentService.getAll();
        return ResponseEntity.ok(studentDto);
    }

    // update method to update student details
    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id, @RequestBody StudentDto studentDto){
        studentDto.setId(id);
        StudentDto updatedStudent = studentService.updateStudent(studentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    // delete api
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("User deleted");
    }

}
