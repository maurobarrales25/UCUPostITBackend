package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO getUserById(int id){
        User user = userRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Usuario no encontrado"));
        return userMapper.userToUserDTO(user);
    }

    public List<UserDTO> getAllUser(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::userToUserDTO).toList();
    }

    public UserDTO createOrGetUser(String auth0id, String name, String email, String imageUrl) {
        User existingUser = userRepository.findUserByauth0id(auth0id);

        if (existingUser != null) {
            System.out.println("Usuario encontrado con Auth0ID: " + auth0id);
            return userMapper.userToUserDTO(existingUser);
        }

        User newUser = new User();
        newUser.setAuth0id(auth0id);
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setImageUrl(imageUrl);

        User savedUser = userRepository.save(newUser);
        System.out.println("Usuario nuevo creado con Auth0ID: " + auth0id);
         return  userMapper.userToUserDTO(savedUser);
    }

    private User findUserByAuth0IdOrThrow(String auth0Id) {
        User user = userRepository.findUserByauth0id(auth0Id);
        if (user == null) {
            throw new EntityNotFoundException("No hay usuario con ese auth0Id");
        }
        return user;
    }

    public UserDTO getUserByAuth0Id(String auth0Id) {
        User user = findUserByAuth0IdOrThrow(auth0Id);
        return userMapper.userToUserDTO(user);
    }

    public List<UserDTO> getFollowsByAuth0Id(String auth0Id) {
        List<User> follows = userRepository.findFollowsByauth0id(auth0Id);
        if (follows == null) {
            throw new EntityNotFoundException("No se encontraron usuarios seguidos para auth0Id " + auth0Id);
        }

        return follows.stream()
                .map(userMapper::userToUserDTO).toList();
    }

    public List<UserDTO> getFollowersByAuth0Id(String auth0Id){
        List<User> followers = userRepository.findFollowersByauth0id(auth0Id);
        if (followers == null){
            throw new EntityNotFoundException("No se encontraron seguidores para auth0Id " + auth0Id);
        }

        return followers.stream()
                .map(userMapper::userToUserDTO).toList();
    }

    public void followUser(String auth0Id, String auth0IdToFollow) {
        User user = findUserByAuth0IdOrThrow(auth0Id);
        User userToFollow = findUserByAuth0IdOrThrow(auth0IdToFollow);

        if (!user.getFollows().contains(userToFollow)) {
            user.follow(userToFollow);
        }
        userRepository.save(user);
    }

    public void unfollowUser(String auth0id, String auth0IdToUnfollow){
        User user = findUserByAuth0IdOrThrow(auth0id);
        User userToUnfollow = findUserByAuth0IdOrThrow(auth0IdToUnfollow);

        if (user.getFollows().contains(userToUnfollow)) {
            user.unfollow(userToUnfollow);
        }
        userRepository.save(user);
    }








}
