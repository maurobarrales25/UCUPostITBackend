package com.example.demo.service;

import com.example.demo.dto.LikeDTO;
import com.example.demo.dto.SaveLikeCommentDTO;
import com.example.demo.dto.SaveLikePostDTO;
import com.example.demo.mapper.LikeMapper;
import com.example.demo.model.Comment;
import com.example.demo.model.Like;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceInterface.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService implements ILikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    private static final LikeMapper likeMapper = LikeMapper.INSTANCE;

    public Like createOrUpdateLikePost(SaveLikePostDTO likePostDTO) {
        Like existingLike = likeRepository.findByUser_Auth0idAndPost_PostId(likePostDTO.getAuth0id(), likePostDTO.getPostId());

        User existingUser = userRepository.findUserByauth0id(likePostDTO.getAuth0id());
        if (existingUser == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }

        Post existingPost = postRepository.findBypostId(likePostDTO.getPostId());
        if (existingPost == null) {
            throw new IllegalArgumentException("El post no existe");
        }

        if (existingLike != null) {
            likeRepository.delete(existingLike);
            return null;
        }

        Like newLike = new Like();
        newLike.setUser(existingUser);
        newLike.setPost(existingPost);

        return likeRepository.save(newLike);
    }

    public Like createOrUpdateCommentPost(SaveLikeCommentDTO likePostDTO) {
        Like existingLike = likeRepository.findByUser_Auth0idAndComment_CommentId(likePostDTO.getAuth0id(), likePostDTO.getCommentId());

        User existingUser = userRepository.findUserByauth0id(likePostDTO.getAuth0id());
        if (existingUser == null) {
            throw new IllegalArgumentException("El usuario no existe");
        }

        Comment existingComment = commentRepository.findByCommentId(likePostDTO.getCommentId());
        if (existingComment == null) {
            throw new IllegalArgumentException("El comentario no existe");
        }

        if (existingLike != null) {
            likeRepository.delete(existingLike);
            return null;
        }

        Like newLike = new Like();
        newLike.setUser(existingUser);
        newLike.setComment(existingComment);

        return likeRepository.save(newLike);
    }


    public List<LikeDTO> findbyUserAuth0id (String auth0id){
        List <Like> likes = likeRepository.findByUser_Auth0id(auth0id);
        return likes.stream()
                .map(likeMapper::likeToDto).toList();
    }

    public Integer countLikesInComment(Integer commentId){
         return likeRepository.countByComment_CommentId(commentId);
    }

    public Integer countLikesInPost(Integer postId){
        return likeRepository.countByPost_PostId(postId);
    }

    public LikeDTO findbyUserAuth0idAndPostId(String userAuth0id, Integer postId){
        Like like = likeRepository.findByUser_Auth0idAndPost_PostId(userAuth0id, postId);
        return likeMapper.likeToDto(like);
    }

    public LikeDTO findbyUserAuth0idAndCommentCommentId(String userAuth0id, Integer postId){
        Like like = likeRepository.findByUser_Auth0idAndComment_CommentId(userAuth0id, postId);
        return likeMapper.likeToDto(like);
    }
}
