package com.example.e1_validate.controller;

import com.example.e1_validate.model.User;
import com.example.e1_validate.service.IUserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String showCreate(Model model)
    {
        model.addAttribute("user",new User());
        return "user_form";
    }
    @PostMapping ("/save")
    public String save(@Validated @ModelAttribute(name = "user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("user",user);
            return "user_form";
        }
        userService.save(user);
        model.addAttribute("message","you have successfully created a new user");
        return "user_form";
    }

}
