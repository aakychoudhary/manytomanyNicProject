package com.jpatest.manytomany.controllers;

import com.jpatest.manytomany.entity.Student;
import com.jpatest.manytomany.repository.CourseRepository;
import com.jpatest.manytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping

    public List<Student>getalldata(){
        return studentRepository.findAll();

    }

//    @GetMapping("/{}")
//
//    public List<Student>findstubyid(@PathVariable long id){
//        return studentRepository.findById(id);
//
//    }


//    @GetMapping("/{studentId}")
//    public ResponseEntity<Student> findStudentById(@PathVariable long id) {
//        Optional<Student> student = studentRepository.findById(id);
//        return student.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping("/{studentId}")
    public Student findStudent(@PathVariable Long studentId)
    {
        return studentRepository.findById(studentId).orElseGet(null);
    }


    @GetMapping("/find/{name}")
public List<Student> findbystudntscontainingByname(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
}



}
