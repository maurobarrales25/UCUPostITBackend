package com.example.demo.controller;

import com.example.demo.dto.PostDTO;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/save/post")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post.getUser().getAuth0id(), post.getTitle(), post.getContent(), post.getCategory());
    }

    @PostMapping("createPost")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        PostDTO createdPost = postService.createPostFromDTO(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PostDTO>> findAll() {
        List<PostDTO> postDTO = postService.getAllPosts();
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("getPostById/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable int id){
        PostDTO postDTO = postService.getPostById(id);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/getPostsByAuth0Id/{auth0Id}")
    public ResponseEntity<List<PostDTO>> getPostsByAuthor(@PathVariable("auth0Id") String auth0Id) {
        List<PostDTO> postDTOs = postService.getPostsFromAuthor(auth0Id);
        return ResponseEntity.ok(postDTOs);
    }

    @GetMapping("/getPostByCategory/{category}")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable("category") String category) {
        List<PostDTO> postDTOS = postService.getPostByCategory(category);
        return ResponseEntity.ok(postDTOS);
    }

}
