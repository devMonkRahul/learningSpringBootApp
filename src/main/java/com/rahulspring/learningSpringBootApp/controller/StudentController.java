package com.rahulspring.learningSpringBootApp.controller;

import com.rahulspring.learningSpringBootApp.dto.StudentDto;
import com.rahulspring.learningSpringBootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public List<StudentDto> getAllStudent() {
        return studentService.getAllStudents();
    }
}
