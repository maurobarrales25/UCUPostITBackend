package com.example.demo.serviceInterface;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

import java.util.List;

public interface IUserService {

    UserDTO getUserById(int id);

    List<UserDTO> getAllUser();

    UserDTO createOrGetUser(String auth0id, String name, String email, String imageUrl);

    User findUserByAuth0IdOrThrow(String auth0Id);

    UserDTO getUserByAuth0Id(String auth0Id);

    List<UserDTO> getFollowsByAuth0Id(String auth0Id);

    List<UserDTO> getFollowersByAuth0Id(String auth0Id);

    void followUser(String auth0Id, String auth0IdToFollow);

    void unfollowUser(String auth0id, String auth0IdToUnfollow);

}
