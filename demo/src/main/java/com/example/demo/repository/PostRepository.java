package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PostRepository  extends JpaRepository<Post, Integer> {

    Post findBypostId(Integer postId);

    List<Post> findAll();

    List<Post> findPostsByCategory(String category);

    List<Post> findPostsByUser_Auth0id(String auth0id);

}
