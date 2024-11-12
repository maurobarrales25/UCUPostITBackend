package com.example.demo.service;

import com.example.demo.dto.PostDTO;
import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private static final PostMapper postMapper = PostMapper.INSTANCE;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostDTO getPostById(int id){
        Post post = postRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Post no encontrado"));
        return postMapper.postToPostDTO(post);
    }

    public List<PostDTO> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        return  posts.stream().map(postMapper::postToPostDTO).toList();
    }

    public PostDTO createPostFromDTO(PostDTO postDTO) {
        User user = userRepository.findUserByauth0id(postDTO.getUser().getAuth0id());
        if (user == null) {
            throw new NoSuchElementException("Usuario no encontrado");
        }

        Post post = postMapper.postDTOToPost(postDTO);
        post.setUser(user);
        post.setPostDate(LocalDate.now());

        postRepository.save(post);

        return postMapper.postToPostDTO(post);
    }


    public Post createPost(String auth0id, String title, String content, String category) {
        User existingUser = userRepository.findUserByauth0id(auth0id);

        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setUser(existingUser);
        newPost.setContent(content);
        newPost.setPostDate(LocalDate.now());
        newPost.setCategory(category);
        return postRepository.save(newPost);
    }

    public List<PostDTO> getPostsFromAuthor(String auth0id ) {
        List<Post> posts = postRepository.findPostsByUser_Auth0id(auth0id);
        return posts.stream()
                .map(postMapper::postToPostDTO).toList();
    }

    public List<PostDTO> getPostByCategory( String category) {
        List<Post> posts = postRepository.findPostsByCategory(category);
        return posts.stream()
                .map(postMapper::postToPostDTO).toList();
    }



}
