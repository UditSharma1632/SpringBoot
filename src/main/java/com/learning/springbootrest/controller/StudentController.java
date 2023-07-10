package com.learning.springbootrest.controller;

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

    // post request
    //    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        student = studentService.createStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // get method using path variable as http://localhost:8080/students/get/1

    @GetMapping("get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
       Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // get method using request param as http://localhost:8080/students/get?id=1
    @GetMapping("get")
    public ResponseEntity<Student> getStudentByParam(@RequestParam Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // get method to obtain every user from db
    @GetMapping("getAll")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> student = studentService.getAll();
        return ResponseEntity.ok(student);
    }

    // update method to update student details
    @PutMapping("update/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id, @RequestBody Student student){
        student.setId(id);
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // delete api
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("User deleted");
    }

}
