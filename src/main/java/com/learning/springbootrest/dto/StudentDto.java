package com.learning.springbootrest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    @NotEmpty(message = "First name is mandatory")
    private String firstName;
    @NotEmpty(message = "Last Name is mandatory")
    private String lastName;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Enter valid email address")
    private String email;
    @NotEmpty(message = "Profile cannot be empty")
    private String branch;
}
