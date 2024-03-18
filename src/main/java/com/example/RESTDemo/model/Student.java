package com.example.RESTDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {
    private int studentId;
    private String studentName;
    private int studentSemester;
    private ArrayList<String> studentSubjects;
}
