package com.rahulspring.learningSpringBootApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Length of the name should be between 3 and 30.")
    private String name;

    @Email
    @NotBlank(message = "Email is Required.")
    private String email;
}