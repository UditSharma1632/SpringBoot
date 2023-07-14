package com.learning.springbootrest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "Student",
        schema = "dummydb",
        uniqueConstraints = {
            @UniqueConstraint(name = "student_email", columnNames = "email_id")
        }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(name = "email_id", nullable = false)
    private String email;
    @Column(nullable = false)
    private String branch;

}
