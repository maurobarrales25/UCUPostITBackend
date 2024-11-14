package com.example.demo.controller;

import com.example.demo.dto.CommentDTO;
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


    @PostMapping("/save/comment")
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment.getUser().getAuth0id(), comment.getPost().getPostId(), comment.getContent());
    }

    @GetMapping("/findByCommentId/{id}")
    public ResponseEntity <CommentDTO> getPostById(@PathVariable int id){
        CommentDTO commentDTO = commentService.getPostById(id);
        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("findByAuthor")
    ResponseEntity<List<CommentDTO>> findByAuthor(String auth0id){
        List<CommentDTO> commentDTOS = commentService.getCommentsFromAuthor(auth0id);
        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/getByPostId{id}")
    ResponseEntity<List<CommentDTO>> findByPost(@PathVariable int id){
        List<CommentDTO> commentDTOS = commentService.getCommentsFromPost(id);
        return ResponseEntity.ok(commentDTOS);
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable int postId){
        commentService.deleteComment(postId);
        return ResponseEntity.noContent().build();
    }

}
