package com.rahulspring.learningSpringBootApp.controller;

import com.rahulspring.learningSpringBootApp.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(21, "Rahul", "rahulpal2023iem@gmail.com");
    }
}
