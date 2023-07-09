package com.learning.springbootrest.controller;

import com.learning.springbootrest.bean.Student;
import com.learning.springbootrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentRepository studentRepo;

    // post request
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentRepo.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable("id") Long id){
       Optional<Student> student = Optional.of(studentRepo.findById(id).get());
        return ResponseEntity.ok(student);
    }
    @GetMapping("get")
    public ResponseEntity<Optional<Student>> getStudentByParam(@RequestParam Long id){
       Optional<Student> student = Optional.of(studentRepo.findById(id).get());
        return ResponseEntity.ok(student);
    }

//    //response entity
//    @GetMapping("bean")
//    @ResponseStatus
//    public ResponseEntity<Student> responseStudent(){
//        Student student = new Student(1, "udit", "sharma");
//        // return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
//    }
//
//    //return list of a bean
//    @GetMapping("list")
//    public ResponseEntity<List<Student>> getStudentsList(){
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(2, "Test", "two"));
//        studentList.add(new Student(3, "Dummy", "three"));
//        studentList.add(new Student(4, "Null", "four"));
//        return ResponseEntity.ok(studentList);
//    }
//
//    //handle path variable as request url
//       // {id} = URI template variable
//    @GetMapping("{id}")
//    public ResponseEntity<Student> getStudentAsPath(@PathVariable int id){
//        Student student = new Student(id, "abc", "xyz");
//        return ResponseEntity.ok(student);
//    }
//
//
//    //handle multiple path variable as request url
//    @GetMapping("{id}/{firstName}/{lastName}")
//    public ResponseEntity<Student> getStudentAsPaths
//    (@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName){
//         Student student = new Student(id, firstName, lastName);
//         return ResponseEntity.ok(student);
//    }
//
//    //rest api with request param
//    @GetMapping("query")
//    public ResponseEntity<Student> getStudentRequestParam
//    (@RequestParam int id){
//        Student student = new Student(id, "Udit", "name-as-param");
//        return ResponseEntity.ok(student);
//    }
//
//    //rest api with multiple request param
//    @GetMapping("queries")
//    public ResponseEntity<Student> getStudentRequestParams
//    (@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
//        Student student = new Student(id, firstName, lastName);
//        return ResponseEntity.ok(student);
//    }
//
//    // put request
//    @PutMapping("{id}/update")
//    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
//        return ResponseEntity.ok(student);
//    }
//
//
//    // delete request
//    @DeleteMapping("{id}/delete")
//    public ResponseEntity<String> deleteStudent(@PathVariable int id){
//        return ResponseEntity.ok("Deleted");
//    }

}
