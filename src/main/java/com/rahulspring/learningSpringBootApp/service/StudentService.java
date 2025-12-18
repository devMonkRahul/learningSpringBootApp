package com.rahulspring.learningSpringBootApp.service;

import com.rahulspring.learningSpringBootApp.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
}
