package com.example.e1_blog_upgrade.controller;

import com.example.e1_blog_upgrade.model.Infor;
import com.example.e1_blog_upgrade.service.IInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/infors")
public class InforController {
    @Autowired
    private IInforService inforService;
    @GetMapping("/{id}/view")
    public String showView(@PathVariable(name = "id")Long id, Model model)
    {
        model.addAttribute("infor",inforService.findById(id));
        return "infor_view";
    }
    @GetMapping("/create")
    public String showCreate( Model model)
    {
        model.addAttribute("infor",new Infor());
        model.addAttribute("message","CREATE INFOR");
        return "infor_form";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("infor") Infor infor, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("infor",infor);
            model.addAttribute("message","CREATE INFOR");
            return "infor_form";
        }
        inforService.save(infor);
        redirectAttributes.addFlashAttribute("message","you have successfully created a infor");
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model)
    {
        model.addAttribute("infor",inforService.findById(id));
        return "infor_form";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id")Long id)
    {
        inforService.deleteById(id);
        return "redirect:/blogs";
    }
}
