package com.news.models;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_post;
    @Column(columnDefinition = "TEXT")
    private String comment_text;
    private Long author;
    private Integer likes = 0;

    public Long getId() {
        return id;
    }

    public String getText() {
        return comment_text;
    }

    public Long getAuthor() {
        return author;
    }

    public Integer getLikes() {
        return likes;
    }

    public Long getId_post() {
        return id_post;
    }

    public void setText(String text) {
        this.comment_text = text;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
