package com.news.controllers;

import com.news.WebApplication;
import com.news.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public String add(@RequestParam String email, @RequestParam String name, @RequestParam String password) {
        Pattern regexMail = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[a-z]{2,4}\\b");
        Pattern regexName = Pattern.compile("^[a-zA-Z]*$");

        Matcher matcherName = regexName.matcher(name);
        Matcher matcherMail = regexMail.matcher(email);

        if (!matcherMail.matches() || !matcherName.matches()) {
            return WebApplication.GSON.toJson("Incorrect personal data");
        } else {
            return WebApplication.GSON.toJson(usersService.add(email, name, password));
        }
    }

    @GetMapping
    public String get(@RequestParam Long id) {
        return WebApplication.GSON.toJson(usersService.get(id));
    }

    @DeleteMapping
    public String delete(@RequestParam Long id) {
        return WebApplication.GSON.toJson(usersService.delete(id));
    }
}
