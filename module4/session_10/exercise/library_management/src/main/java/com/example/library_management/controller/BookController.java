package com.example.library_management.controller;

import com.example.library_management.model.Book;
import com.example.library_management.model.BookForm;
import com.example.library_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping("")
    public String showList(Model model, @RequestParam(name = "name_choose", defaultValue = "") String name_choose, @RequestParam(name = "search_txt", defaultValue = "") String search_txt, @RequestParam(value = "page", defaultValue = "0") int page)
    {
        if (page == -1) {
            page = 0;
        }
        model.addAttribute("books",bookService.findAll(PageRequest.of(page,1)));
        return "books";
    }
    @GetMapping("/create")
    public String showCreate(Model model) {

        model.addAttribute("bookForm",new BookForm());
        return "/book_form";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute(name = "bookForm")BookForm bookForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookForm",bookForm);
            return "/book_form";
        }
        MultipartFile multipartFile = bookForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            File destFile = new File(fileUpload + "img\\" + fileName);
            if (!destFile.exists()){
                multipartFile.transferTo(destFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Book book = new Book(bookForm.getBookName(),bookForm.getBookQuantity(), bookForm.getBookQuantity(), fileName);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "you have successfully created a new book");
//       Redirect chuyển về trang list
        return "redirect:/books";
    }
}
