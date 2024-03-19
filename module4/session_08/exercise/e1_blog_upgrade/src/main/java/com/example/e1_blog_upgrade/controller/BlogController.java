package com.example.e1_blog_upgrade.controller;

import com.example.e1_blog_upgrade.model.Blog;
import com.example.e1_blog_upgrade.repository.IBlogRepository;
import com.example.e1_blog_upgrade.service.IBlogService;
import com.example.e1_blog_upgrade.service.IInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IInforService inforService;

    @GetMapping("")
    public String showList(@RequestParam(name = "show_txt", defaultValue = "") String show_txt, Model model, @RequestParam(name = "name_choose", defaultValue = "") String name_choose, @RequestParam(name = "search_txt", defaultValue = "") String search_txt, @RequestParam(value = "page", defaultValue = "0") int page) {
        if (page == -1) {
            page = 0;
        }
        Page<Blog> blogs = null;

        switch (name_choose) {
            case "title":
                blogs = blogService.findAllByBlogTitleContaining(search_txt, PageRequest.of(page, 1, Sort.by(Sort.Direction.DESC, "blogDate")));
                break;
            case "infor":
                blogs = blogService.findAllByInfor_InforNameContaining(search_txt, PageRequest.of(page, 1, Sort.by(Sort.Direction.DESC, "blogDate")));
                break;
            case "list":
                blogs = blogService.findAllByInfor_InforEmail(show_txt, PageRequest.of(page, 1, Sort.by(Sort.Direction.DESC, "blogDate")));
                break;
            default:
                blogs = blogService.findAll(PageRequest.of(page, 1, Sort.by(Sort.Direction.DESC, "blogDate")));
                break;
        }


        if (blogs.isEmpty()) {
            model.addAttribute("message", "No find blog");
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("search_txt", search_txt);
        model.addAttribute("show_txt", show_txt);
        model.addAttribute("name_choose", name_choose);
        model.addAttribute("infors", inforService.findAll());
        return "blogs";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("infors", inforService.findAll());
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "CREATE BLOG");
        return "blog_form";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute(name = "blog") Blog blog, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("infors", inforService.findAll());
            model.addAttribute("blog",blog);
            model.addAttribute("message", "CREATE BLOG");
            return "/blog_form";
        }
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "you have successfully created new a blog");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("infors", inforService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("dateCurrent",blogService.findById(id).getBlogDate());
        model.addAttribute("message", "UPDATE FORM");
        return "blog_form";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id) {
        blogService.deleteById(id);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/view")
    public String showView(@PathVariable(name = "id") Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("message", blog.getBlogTitle());
        return "blog_view";
    }

}
