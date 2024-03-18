package com.example.RESTDemo.service;

import com.example.RESTDemo.model.Student;
import com.example.RESTDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public void loadData() {
        studentRepo.loadData();
    }

    public ArrayList<Student> getStudents() {
        return studentRepo.getStudents();
    }

    public Object getStudentById(int sId) {
        return studentRepo.getStudentById(sId);
    }

}
