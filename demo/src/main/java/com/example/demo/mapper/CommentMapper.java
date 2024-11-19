package com.example.demo.mapper;

import com.example.demo.dto.CommentDTO;
import com.example.demo.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, PostMapper.class})
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "commentId", target = "commentId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "authorName", target = "authorName")
    @Mapping(source = "commentDate", target = "commentDate")
    CommentDTO commentToCommentDTO(Comment comment);

    @Mapping(source = "commentId", target = "commentId")
    @Mapping(source = "user", target = "user")
    @Mapping(ignore = true, target = "post")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "authorName", target = "authorName")
    @Mapping(source = "commentDate", target = "commentDate")
    Comment commentDTOToComment(CommentDTO commentDTO);
}

