package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceInterface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    private static final CommentMapper commentMapper = CommentMapper.INSTANCE;

    public CommentDTO getPostById(int id){
        Comment comment = commentRepository.findById(id);
        if(comment == null){
            throw new NoSuchElementException();
        }
        return commentMapper.commentToCommentDTO(comment);
    }

    public Comment createComment(String auth0id, Integer postId, String content ) {
        User existingUser = userRepository.findUserByauth0id(auth0id);
        Post existingPost = postRepository.findBypostId(postId);

        Comment newComment = new Comment();
        newComment.setUser(existingUser);
        newComment.setPost(existingPost);
        newComment.setContent(content);
        newComment.setCommentDate(LocalDate.now());
        return commentRepository.save(newComment);
    }

    public List<CommentDTO> getCommentsFromAuthor(String auth0id ) {
        List<Comment> comments = commentRepository.findByUser_Auth0id(auth0id);
        return comments.stream()
                .map(commentMapper::commentToCommentDTO).toList();
    }

    public List<CommentDTO> getCommentsFromPost(int postId ) {
        List<Comment> comments = commentRepository.findByPost_PostId(postId);
        return comments.stream()
                .map(commentMapper::commentToCommentDTO).toList();

    }

    public void deleteComment(int commentId) {
        Comment comment = commentRepository.findById(commentId);
        if (comment == null) {
            throw new NoSuchElementException("Comentario no encontrado");
        }
        commentRepository.delete(comment);
    }

}
