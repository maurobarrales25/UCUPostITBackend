package com.example.demo.repository;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Comment findById(int commentId);

    List<Comment> findByUser_Auth0id(String auth0id);

    List<Comment> findByPost_PostId(int postId);


}
