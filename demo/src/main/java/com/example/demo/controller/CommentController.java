package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.SaveCommentDTO;
import com.example.demo.model.Comment;
import com.example.demo.serviceInterface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<Comment> createComment(@RequestBody SaveCommentDTO commentDTO){
        Comment newComment = commentService.createComment(commentDTO);
        return ResponseEntity.ok(newComment);
    }

    @GetMapping("/findByCommentId/{id}")
    public ResponseEntity <CommentDTO> getPostById(@PathVariable int id){
        CommentDTO commentDTO = commentService.getCommentById(id);
        return ResponseEntity.ok(commentDTO);
    }


    @GetMapping("/findByAuth0Id/{auth0id}")
    ResponseEntity<List<CommentDTO>> findByAuthor(@PathVariable String auth0id){
        List<CommentDTO> commentDTOS = commentService.getCommentsFromAuthor(auth0id);
        return ResponseEntity.ok(commentDTOS);
    }


    @GetMapping("/getCommentListByPostId/{id}")
    ResponseEntity<List<Comment>> findByPost(@PathVariable int id){
        List<Comment> comment = commentService.getCommentsFromPost(id);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable int postId){
        commentService.deleteComment(postId);
        return ResponseEntity.noContent().build();
    }

}
