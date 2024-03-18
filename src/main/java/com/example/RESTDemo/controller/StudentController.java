package com.example.RESTDemo.controller;

import com.example.RESTDemo.model.Student;
import com.example.RESTDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(path = "/")
    public String getHome() {
        return "Hello world";
    }

    @GetMapping(path = "/load")
    public void loadData() {
        studentService.loadData();
    }

    @GetMapping(path = "/students", produces = "application/xml")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "/student/{sId}")
    public Object getStudentById(@PathVariable("sId") int sId) {
        return studentService.getStudentById(sId);
    }

    @PostMapping(path = "/student", consumes = "application/xml", produces = "application/xml")
    public Object addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping(path = "/student")
    public Object updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/student/{studentId}")
    public Object deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }
}
