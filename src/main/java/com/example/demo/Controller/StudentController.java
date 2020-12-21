package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;

//list of all students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return studentService.getAll();
    }



//find student by id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable("studentId") int studentId){
        return studentService.getById(studentId);
    }

    //create students
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return studentService.createNewStudent(student);
    }
    //update by id
    @PutMapping("/students/{studentId}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("studentId") int studentId, @RequestBody Student student){
        return studentService.updateStudentById(studentId, student);
    }

    //delete student by id
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("studentId") int studentId){
        return studentService.deleteStudents(studentId);
    }
}
