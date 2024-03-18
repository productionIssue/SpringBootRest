package com.example.RESTDemo.repository;

import com.example.RESTDemo.model.Error;
import com.example.RESTDemo.model.Student;
import com.example.RESTDemo.model.Success;
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

    public Object addStudent(Student student) {
        boolean isStudentPresent = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (student.getStudentId() == studentList.get(i).getStudentId()) {
                isStudentPresent = true;
                break;
            }
        }
        if (isStudentPresent) {
            return new Error(-3, "Can't add student with given ID in database as same ID present");
        } else {
            studentList.add(student);
            return studentList.get(studentList.size()-1);
        }
    }

    public Object updateStudent(Student student) {
        boolean isStudentPresent = false;
        int studentPresentIndex = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (student.getStudentId() == studentList.get(i).getStudentId()) {
                isStudentPresent = true;
                studentPresentIndex = i;
                break;
            }
        }
        if (isStudentPresent) {
            studentList.get(studentPresentIndex).setStudentId(student.getStudentId());
            studentList.get(studentPresentIndex).setStudentName(student.getStudentName());
            studentList.get(studentPresentIndex).setStudentSemester(student.getStudentSemester());
            studentList.get(studentPresentIndex).setStudentSubjects(student.getStudentSubjects());

            return studentList.get(studentPresentIndex);
        } else {
            return new Error(-4, "Can't update as provided student with given ID doesn't exist");
        }
    }

    public Object deleteStudent(int studentId) {
        if(studentId<0) {
            return new Error(-2, "student Id can't be negative");
        } else {
            boolean isStudentPresent = false;
            int studentPresentIndex = -1;
            for (int i = 0; i < studentList.size(); i++) {
                if (studentId == studentList.get(i).getStudentId()) {
                    isStudentPresent = true;
                    studentPresentIndex = i;
                    break;
                }
            }
            if (isStudentPresent) {
                studentList.remove(studentList.get(studentPresentIndex));
                return new Success(0, "Student successfully removed from DB");
            } else {
                return new Error(-4, "Can't delete as provided student with given ID doesn't exist");
            }
        }
    }
}
