package com.example.demo.dto;

public class SaveCommentDTO {

    private String auth0id;
    private Integer postId;
    private String content;

    public SaveCommentDTO(String auth0id, Integer postId, String content) {
        this.auth0id = auth0id;
        this.postId = postId;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }
}
