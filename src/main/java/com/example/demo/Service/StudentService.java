package com.example.demo.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    //create new student
    public  ResponseEntity<Student> createNewStudent(@RequestBody Student student) {
        try {
            Student student1 = studentRepository.save(student);
            return new ResponseEntity<>(student1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //find student by id
    public ResponseEntity<Student> getById(int studentId) {
        Optional<Student> s = studentRepository.findById(studentId);
        if (s.isPresent())
            return new ResponseEntity<>(s.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //list of all students
       public ResponseEntity <List<Student>> getAll(){
           try {
               List<Student> students = studentRepository.findAll();
               if (students.isEmpty())
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
              return new ResponseEntity<>(students, HttpStatus.OK);
            } catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

     //update student by id
    public ResponseEntity<Student> updateStudentById(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(studentId);
        if (studentData.isPresent()) {
            Student student1 = studentData.get();
            student1.setStudentName(student.getStudentName());
            student1.setEmail(student.getEmail());
            student1.setSupervisorSupervisorId(student.getSupervisorSupervisorId());

            return new ResponseEntity<>(studentRepository.save(student1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 //delete student by id
    public ResponseEntity<HttpStatus> deleteStudents(@PathVariable("studentId") int studentId){
        try{
            studentRepository.deleteById(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



