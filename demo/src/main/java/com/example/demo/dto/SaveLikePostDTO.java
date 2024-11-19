package com.example.demo.dto;

public class SaveLikePostDTO {

    private String auth0id;
    private Integer postId;

    public SaveLikePostDTO(String auth0id, Integer postId) {
        this.auth0id = auth0id;
        this.postId = postId;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
