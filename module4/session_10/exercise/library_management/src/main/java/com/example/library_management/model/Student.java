package com.example.library_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true)
    private String studentMssv;
    private String studentName;
    private LocalDate dayOfBirth;
    private String studentNumberPhone;
    private String studentAddress;
    private String studentEmail;


}
