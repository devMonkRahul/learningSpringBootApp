package com.rahulspring.learningSpringBootApp.service.impl;

import com.rahulspring.learningSpringBootApp.dto.AddStudentRequestDto;
import com.rahulspring.learningSpringBootApp.dto.StudentDto;
import com.rahulspring.learningSpringBootApp.entity.Student;
import com.rahulspring.learningSpringBootApp.repository.StudentRepository;
import com.rahulspring.learningSpringBootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student student = modelMapper.map(addStudentRequestDto, Student.class);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public void deleteStudentById(String id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(String id,  AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(String id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id " + id));

        updates.forEach((key, value) -> {
           switch (key) {
               case "name":
                   student.setName((String) value);
                   break;
               case "email":
                   student.setEmail((String) value);
                   break;
               default:
                   throw new IllegalArgumentException("Student not found with id " + id);
           }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
