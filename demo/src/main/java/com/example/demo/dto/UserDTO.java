package com.example.demo.dto;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private int userId;
    private String name;
    private String username;
    private String email;
    private String auth0id;
    private String imageUrl;
    private List<UserDTO> follows = new ArrayList<>();
    private List<UserDTO> followers = new ArrayList<>();

    public UserDTO(int userId, String name, String username, String email, String auth0id, String imageUrl, ArrayList<UserDTO> follows, ArrayList<UserDTO> followers) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.email = email;
        this.auth0id = auth0id;
        this.imageUrl = imageUrl;
        this.follows = follows;
        this.followers = followers;
    }

    public UserDTO() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<UserDTO> getFollows() {
        return follows;
    }

    public void setFollows(List<UserDTO> follows) {
        this.follows = follows;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", auth0id='" + auth0id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
