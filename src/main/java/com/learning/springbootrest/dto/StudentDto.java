package com.learning.springbootrest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Student DTO model class"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    @Schema(
            description = "Student's first name"
    )
    @NotEmpty(message = "First name is mandatory")
    private String firstName;


    @Schema(
            description = "Student's last name"
    )
    @NotEmpty(message = "Last Name is mandatory")
    private String lastName;


    @Schema(
            description = "Student's email"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Enter valid email address")
    private String email;


    @Schema(
            description = "Student's branch name"
    )
    @NotEmpty(message = "Profile cannot be empty")
    private String branch;
}
