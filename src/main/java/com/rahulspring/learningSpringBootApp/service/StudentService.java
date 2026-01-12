package com.rahulspring.learningSpringBootApp.service;

import com.rahulspring.learningSpringBootApp.dto.AddStudentRequestDto;
import com.rahulspring.learningSpringBootApp.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(String id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(String id);

    StudentDto updateStudent(String id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(String id, Map<String, Object> updates);
}
