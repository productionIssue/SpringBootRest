package com.example.RESTDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @GetMapping("/")
    @ResponseBody
    public String getHome() {
        return "Hello world";
    }
}
