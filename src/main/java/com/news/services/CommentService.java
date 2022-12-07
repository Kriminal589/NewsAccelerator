package com.news.services;

import com.news.DAO.AdminDAO;
import com.news.DAO.CommentDAO;
import com.news.models.Comment;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentDAO commentDAO;
    private final AdminDAO adminDAO;

    @Autowired
    public CommentService(CommentDAO commentDAO, AdminDAO adminDAO) {
        this.commentDAO = commentDAO;
        this.adminDAO = adminDAO;
    }

    public Iterable<Comment> getAllByIdPost(Long id_post) {
        return commentDAO.findAllById_post(id_post);
    }

    public Optional<Comment> get(Long id) {
        return commentDAO.findById(id);
    }

    public Iterable<Comment> getAllByAuthor(Long idAuthor) {
        return commentDAO.getAllByAuthor(idAuthor);
    }

    public Comment add(Long idPost, String commentText, Long idAuthor) {
        try {
            Comment comment = new Comment();
            comment.setAuthor(idAuthor);
            comment.setText(commentText);
            comment.setId_post(idPost);
            comment.setLikes(0);

            commentDAO.save(comment);

            return comment;
        } catch (Exception e) {
            return nullComment();
        }
    }

    public Comment addLike(Long id) {
        Optional<Comment> optionalComment = commentDAO.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();

            int likes = comment.getLikes() + 1;
            comment.setLikes(likes);

            commentDAO.save(comment);

            return comment;
        } else {
            return nullComment();
        }
    }

    public Comment removeLike(Long id) {
        Optional<Comment> optionalComment = commentDAO.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();

            int likes = comment.getLikes() - 1;
            comment.setLikes(likes);

            commentDAO.save(comment);

            return comment;
        } else {
            return nullComment();
        }
    }

    public Optional<Comment> delete(Long id) {
        Optional<Comment> optionalComment = commentDAO.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();

            commentDAO.delete(comment);
        }

        return optionalComment;
    }

    public Comment rewrite(String text, Long id, Long idAuthor) {
        Optional<Comment> optionalComment = commentDAO.findById(id);

        if (optionalComment.isPresent() &&
                (adminDAO.findById(idAuthor).isPresent() || Objects.equals(optionalComment.get().getAuthor(), idAuthor))) {
            Comment comment = optionalComment.get();
            comment.setText(text);

            commentDAO.save(comment);

            return comment;
        } else {
            return nullComment();
        }
    }

    public boolean deleteAll(Long idPost) {
        return commentDAO.deleteAllById_post(idPost);
    }

    private @NotNull Comment nullComment() {
        Comment comment = new Comment();

        comment.setAuthor(-1L);
        comment.setText(null);
        comment.setId_post(-1L);
        comment.setLikes(-1);

        return comment;
    }
}
