package com.news.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping()
    public @ResponseBody String registration(@NotNull Model model) {
        model.addAttribute("title", "Authorization");
        return "registration";
    }
}
