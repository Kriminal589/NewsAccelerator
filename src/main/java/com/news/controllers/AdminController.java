package com.news.controllers;

import com.news.WebApplication;
import com.news.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String get(@RequestParam Long id) {
        return WebApplication.GSON.toJson(adminService.get(id));
    }

    @PostMapping
    public String add(@RequestParam Long id) {
        return WebApplication.GSON.toJson(adminService.add(id));
    }
}
