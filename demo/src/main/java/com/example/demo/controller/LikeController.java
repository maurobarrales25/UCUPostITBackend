package com.example.demo.controller;

import com.example.demo.dto.LikeDTO;
import com.example.demo.dto.SaveLikeCommentDTO;
import com.example.demo.dto.SaveLikePostDTO;
import com.example.demo.model.Like;
import com.example.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/savePostLike")
    public ResponseEntity<Like> saveLikePost(@RequestBody SaveLikePostDTO likePostDTO) {
        Like newLike = likeService.createOrUpdateLikePost(likePostDTO);
        return ResponseEntity.ok(newLike);
    }

    @PostMapping("/saveCommentLike")
    public ResponseEntity<Like> saveLikeComment(@RequestBody SaveLikeCommentDTO likeCommentDTO) {
        Like newLike = likeService.createOrUpdateCommentPost(likeCommentDTO);
        return ResponseEntity.ok(newLike);
    }

    @GetMapping("/getLikesByAuth0id/{auth0id}")
    public ResponseEntity<List<LikeDTO>> getAllLikesFromUser(@PathVariable String auth0id) {
        List<LikeDTO> likes = likeService.findbyUserAuth0id(auth0id);
        return ResponseEntity.ok(likes);
    }

    @GetMapping("/countLikesPost/{postId}")
    public Integer getCountLikesFromPost(@PathVariable Integer postId) {
        return likeService.countLikesInPost(postId);
    }

    @GetMapping("/countLikesComment/{commentId}")
    public Integer getCountLikesFromComment(@PathVariable Integer commentId) {
        return likeService.countLikesInComment(commentId);
    }

}