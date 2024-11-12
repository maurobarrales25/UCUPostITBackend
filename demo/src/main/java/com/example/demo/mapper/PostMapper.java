package com.example.demo.mapper;
import com.example.demo.model.Post;
import com.example.demo.dto.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "authorName", target = "authorName")
    @Mapping(source = "imageURL", target = "imageURL")
    @Mapping(source = "postDate", target = "postDate")
    PostDTO postToPostDTO(Post post);

    @Mapping(source = "postId", target = "postId")
    @Mapping(source = "user", target = "user")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "authorName", target = "authorName")
    @Mapping(source = "imageURL", target = "imageURL")
    @Mapping(source = "postDate", target = "postDate")
    Post postDTOToPost(PostDTO postDTO);

}
