package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column
    private String name;

    @Column
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String auth0id;

    @Column(length = 2000)
    private String imageUrl;


    @ManyToMany
    @JoinTable(
            name = "user_follows",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "followed_user_id"))
    @JsonIgnore
    private List<User> follows = new ArrayList<>();

    @ManyToMany (mappedBy = "follows")
    @JsonIgnore
    private List<User> followers = new ArrayList<>();


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

    public List<User> getFollows() {
        return follows;
    }

    public void setFollows(List<User> follows) {
        this.follows = follows;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void follow(User userToFollow) {
        if (!this.follows.contains(userToFollow)) {
            this.follows.add(userToFollow);
            userToFollow.addFollower(this);
        }
    }

    public void unfollow(User userToUnfollow) {
        this.follows.remove(userToUnfollow);

    }

    public void addFollower(User userToAdd) {
        if (!this.follows.contains(userToAdd)) {
            this.follows.add(userToAdd);
            userToAdd.addFollower(this);
        }
    }

    public void removeFollower(User userToRemove) {
        if (this.followers.contains(userToRemove)) {
            this.followers.remove(userToRemove);
        }
    }

    public boolean isFollowing(User userToFollow) {
        return this.followers.contains(userToFollow);
    }

    public boolean isFollower(User userToFollow) {
        return this.followers.contains(userToFollow);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", auth0id='" + auth0id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
