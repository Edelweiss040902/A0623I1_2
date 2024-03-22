package com.example.library_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrow-detail")
public class BorrowDetailController
{
    @GetMapping("/{id}/view")
    public String showView()
    {
        return "borrow_detail";
    }
}
