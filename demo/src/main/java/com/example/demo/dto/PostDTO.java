package com.example.demo.dto;

import com.example.demo.model.User;

import java.time.LocalDate;

public class PostDTO {

    private int postId;
    private User user;
    private String title;
    private String content;
    private String authorName;
    private String imageURL;
    private LocalDate postDate;
    private String category;


    public PostDTO(int postId, User user, String title, String content, String authorName, LocalDate postDate,  String category) {
        this.postId = postId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.postDate = postDate;
        this.category = category;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", postDate=" + postDate +
                ", category='" + category + '\'' +
                '}';
    }
}
