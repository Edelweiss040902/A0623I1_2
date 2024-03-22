package com.example.library_management.controller;

import com.example.library_management.model.Account;
import com.example.library_management.service.ILoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @GetMapping("")
    public String showLogin(@CookieValue(value = "username",defaultValue = "")String username,@CookieValue(value = "password",defaultValue = "") String password, Model model)
    {
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "login";
    }
    @PostMapping("/login")
    private String login(@RequestParam(name = "username") String username
            , @RequestParam(name = "password") String password
            , @RequestParam(name = "remember",defaultValue = "false") Boolean remember
            , HttpServletResponse response)
    {
        if(loginService.findAllByAccountNameAndAccountPassword(username,password)!=null)
        {
            if(remember)
            {
                Cookie cookie = new Cookie("username",username);
                Cookie cookie1 = new Cookie("password",password);
                cookie.setMaxAge(1*24*60*60);
                cookie1.setMaxAge(1*24*60*60);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            return "home";
        }
        return "redirect:";
    }
}
