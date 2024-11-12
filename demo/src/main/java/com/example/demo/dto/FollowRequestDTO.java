package com.example.demo.dto;

public class FollowRequestDTO {
    private String auth0Id;
    private String auth0IdToFollow;

    // Getters y setters
    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getAuth0IdToFollow() {
        return auth0IdToFollow;
    }

    public void setAuth0IdToFollow(String auth0IdToFollow) {
        this.auth0IdToFollow = auth0IdToFollow;
    }
}
