package com.example.e2.controller;

import com.example.e2.model.Song;
import com.example.e2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Model model)
    {
        model.addAttribute("songs",songService.findAll());
        return "songs";
    }
    @GetMapping("/create")
    public String showCreate(Model model)
    {
        model.addAttribute("song",new Song());
        return "song_form";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute(name = "song")Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("song",song);
            return "song_form";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message","you are have successfully created a new song");
        return "redirect:/songs";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable(name = "id")Long id, Model model)
    {
        model.addAttribute("song",songService.findById(id));
        return "song_form";
    }
}
