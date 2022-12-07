package com.news.controllers;

import com.news.WebApplication;
import com.news.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/post")
    public String getAllByIdPost(@RequestParam Long idPost) {
        return WebApplication.GSON.toJson(commentService.getAllByIdPost(idPost));
    }

    @GetMapping("/getAllByAuthor")
    public String getAllByAuthor(@RequestParam Long idAuthor) {
        return WebApplication.GSON.toJson(commentService.getAllByAuthor(idAuthor));
    }

    @GetMapping("/get")
    public String get(@RequestParam Long id) {
        return WebApplication.GSON.toJson(commentService.get(id));
    }

    @PostMapping("/add")
    public String add(@RequestParam Long idPost, @RequestParam String commentText, @RequestParam Long idAuthor) {
        return WebApplication.GSON.toJson(commentService.add(idPost, commentText, idAuthor));
    }

    @GetMapping("/addLike")
    public String add(@RequestParam Long id) {
        return WebApplication.GSON.toJson(commentService.addLike(id));
    }

    @GetMapping("/removeLike")
    public String removeLike(@RequestParam Long id) {
        return WebApplication.GSON.toJson(commentService.removeLike(id));
    }

    @PostMapping("/rewrite")
    public String rewrite(@RequestParam String text, @RequestParam Long id, @RequestParam Long idAuthor) {
        return WebApplication.GSON.toJson(commentService.rewrite(text, id, idAuthor));
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        return WebApplication.GSON.toJson(commentService.delete(id));
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(@RequestParam Long idPost) {
        return WebApplication.GSON.toJson(commentService.deleteAll(idPost));
    }
}
