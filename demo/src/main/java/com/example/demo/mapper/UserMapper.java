package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "auth0id", target = "auth0id")
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(target = "follows", ignore = true)  // Ignorar la propiedad 'follows'
    @Mapping(target = "followers", ignore = true)  // Ignorar la propiedad 'followers'
    UserDTO userToUserDTO(User user);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "auth0id", target = "auth0id")
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(target = "follows", ignore = true)  // Ignorar la propiedad 'follows'
    @Mapping(target = "followers", ignore = true)  // Ignorar la propiedad 'followers'
    User userDTOToUser(UserDTO userDTO);
}

