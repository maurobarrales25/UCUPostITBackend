package com.example.demo.serviceInterface;

import com.example.demo.dto.LikeDTO;
import com.example.demo.dto.SaveLikeCommentDTO;
import com.example.demo.dto.SaveLikePostDTO;
import com.example.demo.model.Like;

import java.util.List;

public interface ILikeService {

    List<LikeDTO> findbyUserAuth0id (String auth0id);

    Like createOrUpdateLikePost(SaveLikePostDTO likePostDTO);

    Like createOrUpdateCommentPost(SaveLikeCommentDTO likePostDTO);

    Integer countLikesInComment(Integer commentId);

    Integer countLikesInPost(Integer postId);

    LikeDTO findbyUserAuth0idAndPostId(String userAuth0id, Integer postId);

    LikeDTO findbyUserAuth0idAndCommentCommentId(String userAuth0id, Integer postId);

}
