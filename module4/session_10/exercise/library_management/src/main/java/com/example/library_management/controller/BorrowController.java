package com.example.library_management.controller;

import com.example.library_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("borrows")
public class BorrowController
{
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public String showList(Model model)
    {

        model.addAttribute("books",bookService.findAll());
//        model.addAttribute("borrow",)
        return "borrows";
    }
}
