package com.rahulspring.learningSpringBootApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String id;
    private String name;
    private String email;
}
