package com.example.RESTDemo.repository;

import com.example.RESTDemo.model.Error;
import com.example.RESTDemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Repository
public class StudentRepo {
    ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList());

    public void loadData() {
        ArrayList<String> l1 = new ArrayList<String>(Arrays.asList("C++", "Java", "DSA"));
        ArrayList<String> l2 = new ArrayList<String>(Arrays.asList("Electronic Device", "Machine Learning"));
        studentList.add(new Student(1, "Supratim", 6, l1));
        studentList.add(new Student(2, "Prabal", 4, l2));
    }

    public ArrayList<Student> getStudents() {
        return this.studentList;
    }

    public Object getStudentById(int sId) {
        if(sId<0) {
            return new Error(-2, "student Id can't be negative");
        } else {
            boolean isStudentPresent = false;
            int studentPresentIndex = -1;
            for (int i = 0; i < studentList.size(); i++) {
                if (sId == studentList.get(i).getStudentId()) {
                    isStudentPresent = true;
                    studentPresentIndex = i;
                    break;
                }
            }
            if (isStudentPresent) {
                return studentList.get(studentPresentIndex);
            } else {
                return new Error(-1, "Can't find student with given ID in database");
            }
        }
    }
}
