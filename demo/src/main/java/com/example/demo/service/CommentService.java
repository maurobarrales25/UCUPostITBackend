package com.example.demo.service;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.SaveCommentDTO;
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

    public CommentDTO getCommentById(int id){
        Comment comment = commentRepository.findByCommentId(id);
        if(comment == null){
            throw new NoSuchElementException();
        }
        return commentMapper.commentToCommentDTO(comment);
    }

    public Comment createComment(SaveCommentDTO commentDTO ) {
        User existingUser = userRepository.findUserByauth0id(commentDTO.getAuth0id());
        Post existingPost = postRepository.findBypostId(commentDTO.getPostId());

        Comment newComment = new Comment();
        newComment.setUser(existingUser);
        newComment.setPost(existingPost);
        newComment.setContent(commentDTO.getContent());
        newComment.setCommentDate(LocalDate.now());

        commentRepository.save(newComment);

        return newComment;
    }

    public List<CommentDTO> getCommentsFromAuthor(String auth0id ) {
        List<Comment> comments = commentRepository.findByUser_Auth0id(auth0id);
        return comments.stream()
                .map(commentMapper::commentToCommentDTO).toList();
    }

    public List<Comment> getCommentsFromPost(int postId ) {
        List<Comment> comments = commentRepository.findCommentsByPostId(postId);
        return comments;

    }

    public void deleteComment(int commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        if (comment == null) {
            throw new NoSuchElementException("Comentario no encontrado");
        }
        commentRepository.delete(comment);
    }

}
