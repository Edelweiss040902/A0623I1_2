package com.example.library_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(unique = true)
    private String accountName;
    private String accountPassword;
    @Column(unique = true)
    @Email(message = "email không đúng định dạng")
    private String accountEmail;


    @ManyToOne
    @JoinColumn(name ="role_id")
    private Role role;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;



}
