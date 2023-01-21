package com.backend.sanchit.controller;


import com.backend.sanchit.Exception.ResourceNotFoundException;
import com.backend.sanchit.model.User;
import com.backend.sanchit.repository.UserRepository;
import com.backend.sanchit.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtility jwtUtility;

    // login user
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
      List<User> users =  userRepository.findAll();
      String token = jwtUtility.createToken(user);

      for(User u: users) {
          if(u.getUsername().equals(user.getUsername())) {
              if(u.getPassword().equals(user.getPassword())) {
                  return user;
              }
              else {
                  return null;
              }
          }
      }
      return null;
    }

    // get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // create user rest api
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // get user by id rest api
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("USer not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    // update user rest api

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        user.setUserName(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());


        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user rest api
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
