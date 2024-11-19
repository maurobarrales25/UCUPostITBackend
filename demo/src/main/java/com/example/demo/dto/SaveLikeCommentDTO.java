package com.example.demo.dto;

public class SaveLikeCommentDTO {

    private String auth0id;
    private Integer commentId;

    public SaveLikeCommentDTO(String auth0id, Integer commentId) {
        this.auth0id = auth0id;
        this.commentId = commentId;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
