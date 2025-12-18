package com.rahulspring.learningSpringBootApp.service.impl;

import com.rahulspring.learningSpringBootApp.dto.StudentDto;
import com.rahulspring.learningSpringBootApp.entity.Student;
import com.rahulspring.learningSpringBootApp.repository.StudentRepository;
import com.rahulspring.learningSpringBootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
    }
}
