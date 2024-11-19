package com.example.demo.controller;

import com.example.demo.dto.FollowUnfollowRequestDTO;
import com.example.demo.serviceInterface.IUserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    IUserService userService;

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> userDTOList = userService.getAllUser();
        return ResponseEntity.ok(userDTOList);
    }


    @GetMapping("/getUserByAuth0Id/{auth0Id}")
    public ResponseEntity<UserDTO> getUserByAuth0Id(@PathVariable("auth0Id") String auth0Id) {
        UserDTO userDTO = userService.getUserByAuth0Id(auth0Id);
        return ResponseEntity.ok(userDTO);
    }


    @GetMapping("/getFollowsByAuth0Id/{auth0Id}")
    public ResponseEntity<List<UserDTO>> getFollowsByAuth0Id(@PathVariable("auth0Id") String auth0Id){
        List<UserDTO> follows = userService.getFollowsByAuth0Id(auth0Id);
        return ResponseEntity.ok(follows);
    }


    @GetMapping("/getFollowersByAuth0Id/{auth0Id}")
    public ResponseEntity<List<UserDTO>> getFollowersByAuth0Id(@PathVariable("auth0Id") String auth0Id){
        List<UserDTO> followers = userService.getFollowersByAuth0Id(auth0Id);
        return ResponseEntity.ok(followers);
    }


    @PostMapping("/createUser")
    public UserDTO createUser(@RequestBody User user) {
         UserDTO userDTO = userService.createOrGetUser(user.getAuth0id(), user.getName(), user.getEmail(), user.getImageUrl());
        return userDTO;
    }

    @PostMapping("/follow")
    public ResponseEntity<Void> followUser(@RequestParam String auth0Id, @RequestParam String auth0IdToFollow) {
        try {
            userService.followUser(auth0Id, auth0IdToFollow);

            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/unfollow")
    public ResponseEntity<Void> unfollowUser(@RequestParam String auth0Id, @RequestParam String auth0IdToUnfollow) {
        try {
            userService.unfollowUser(auth0Id, auth0IdToUnfollow);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/isFollowing")
    public ResponseEntity<Boolean> getFollowStatus(@RequestBody FollowUnfollowRequestDTO followUnfollowRequestDTO) {
        boolean isFollowing = userService.isFollowing(followUnfollowRequestDTO);
        return ResponseEntity.ok(isFollowing);
    }

    @PostMapping("/toggleFollow")
    public ResponseEntity<Void> toggleFollow(@RequestBody FollowUnfollowRequestDTO followUnfollowRequestDTO) {
        userService.toggleFollowUser(followUnfollowRequestDTO);
        return ResponseEntity.ok().build();
    }


}
