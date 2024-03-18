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

    @GetMapping("/")
    public String getHome() {
        return "Hello world";
    }

    @GetMapping("/load")
    public void loadData() {
        studentService.loadData();
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{sId}")
    public Object getStudentById(@PathVariable("sId") int sId) {
        return studentService.getStudentById(sId);
    }

}
