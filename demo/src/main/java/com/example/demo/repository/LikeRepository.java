package com.example.demo.repository;

import com.example.demo.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    Like findByLikeId(Integer likeId);

    List<Like> findByUser_Auth0id(String auth0id);

    Integer countByComment_CommentId(Integer commentId);

    Integer countByPost_PostId(Integer postId);

    Like findByUser_Auth0idAndPost_PostId(String userAuth0id, Integer postId);

    Like findByUser_Auth0idAndComment_CommentId(String userAuth0id, Integer commentId);

}
