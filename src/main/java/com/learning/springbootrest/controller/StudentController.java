package com.learning.springbootrest.controller;

import com.learning.springbootrest.dto.StudentDto;
import com.learning.springbootrest.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "CRUD rest api for Student",
        description = " We will perform create get update and delete operations on student object"
)
@RestController
@AllArgsConstructor
@RequestMapping("students")
public class StudentController {

    StudentService studentService;

    // post request using dto object
    @Operation(
            summary = "This will create new Student"
    )
    @ApiResponse(
            responseCode = "201"
    )
    @PostMapping("create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid StudentDto studentDto){
        StudentDto student = studentService.createStudent(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }




    // get method using dto object
    @Operation(
            summary = "This will fetch Student by id"
    )
    @ApiResponse(
            responseCode = "200"
    )
    @GetMapping("get/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id){
       StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }






    // get method using dto object
    @Operation(
            summary = "This will fetch Student by id and we will use query param"
    )
    @ApiResponse(
            responseCode = "200"
    )
    @GetMapping("get")
    public ResponseEntity<StudentDto> getStudentByParam(@RequestParam Long id){
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }





    // get method to obtain every student from db
    @Operation(
            summary = "This will fetch all Students"
    )
    @ApiResponse(
            responseCode = "200"
    )
    @GetMapping("getAll")
    public ResponseEntity<List<StudentDto>> getStudents(){
        List<StudentDto> studentDto = studentService.getAll();
        return ResponseEntity.ok(studentDto);
    }




    // update method to update student details
    @Operation(
            summary = "This will update a single Student by using its id"
    )
    @ApiResponse(
            responseCode = "200"
    )
    @PutMapping("update/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id, @RequestBody @Valid StudentDto studentDto){
        studentDto.setId(id);
        StudentDto updatedStudent = studentService.updateStudent(studentDto);
        return ResponseEntity.ok(updatedStudent);
    }




    // delete api
    @Operation(
            summary = "This will delete a single Student by using its id"
    )
    @ApiResponse(
            responseCode = "200"
    )
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("User deleted");
    }

}
