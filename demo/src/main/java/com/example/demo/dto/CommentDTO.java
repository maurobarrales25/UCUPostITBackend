package com.example.demo.dto;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.time.LocalDate;

public class CommentDTO {

    private int commentId;
    private User user;
    private Post post;
    private String content;
    private String authorName;
    private LocalDate commentDate = LocalDate.now();


    public CommentDTO(int commentId, User user, Post post,  String content, String authorName) {
        this.commentId = commentId;
        this.user = user;
        this.post = post;
        this.content = content;
        this.authorName = authorName;

    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int postId) {
        this.commentId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate postDate) {
        this.commentDate = postDate;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", post=" + post +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
