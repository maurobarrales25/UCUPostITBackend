package com.example.demo.serviceInterface;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;

import java.util.List;

public interface ICommentService {

    CommentDTO getPostById(int id);

    Comment createComment(String auth0id, Integer postId, String content );

    List<CommentDTO> getCommentsFromAuthor(String auth0id );

    List<CommentDTO> getCommentsFromPost(int postId );

    void deleteComment(int commentId);


}
