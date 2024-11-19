package com.example.demo.mapper;

import com.example.demo.dto.LikeDTO;
import com.example.demo.model.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, PostMapper.class, CommentMapper.class})
public interface LikeMapper {

    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(source = "likeId", target = "likeId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "comment", target = "comment")
    LikeDTO likeToDto(Like like);

    @Mapping(source = "likeId", target = "likeId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "post", target = "post")
    @Mapping(source = "comment", target = "comment")
    Like DTOToLike(LikeDTO likeDTO);

}
