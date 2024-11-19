package com.example.demo.serviceInterface;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.SaveCommentDTO;
import com.example.demo.model.Comment;

import java.util.List;

public interface ICommentService {

    CommentDTO getCommentById(int id);

    Comment createComment(SaveCommentDTO saveCommentDTO);

    List<CommentDTO> getCommentsFromAuthor(String auth0id );

    List<Comment> getCommentsFromPost(int postId );

    void deleteComment(int commentId);


}
