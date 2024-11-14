package com.example.demo.serviceInterface;

import com.example.demo.dto.PostDTO;
import com.example.demo.model.Post;

import java.util.List;

public interface IPostService {

    PostDTO getPostById(int id);

    List<PostDTO> getAllPosts();

    Post createPost(String auth0id, String title, String content, String category);

    List<PostDTO> getPostsFromAuthor(String auth0id );

    List<PostDTO> getPostByCategory( String category);

    void deletePost(int postId);



}
