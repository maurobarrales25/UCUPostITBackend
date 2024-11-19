package com.example.demo.dto;

public class FollowUnfollowRequestDTO {
    private String auth0id;
    private String auth0idToFollowUnfollow;


    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public String getAuth0idToFollowUnfollow() {
        return auth0idToFollowUnfollow;
    }

    public void setAuth0idToFollowUnfollow(String auth0idToFollowUnfollow) {
        this.auth0idToFollowUnfollow = auth0idToFollowUnfollow;
    }
}
