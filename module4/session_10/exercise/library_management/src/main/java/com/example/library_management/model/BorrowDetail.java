package com.example.library_management.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "borrow-detail")
public class BorrowDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long borrowDetailId;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDate borrowStartDay;
    private LocalDate borrowEndDay;
    private Integer borrowBookQuantity;


}
