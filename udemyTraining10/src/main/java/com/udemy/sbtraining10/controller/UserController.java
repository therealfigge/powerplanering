/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.sbtraining10.controller;

import com.udemy.sbtraining10.model.user.request.UserRequest;
import com.udemy.sbtraining10.model.user.response.UserResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fredr
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    Map<String, UserResponse> user;
    
    @PostMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        }, 
        consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        })
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setFirstName(userRequest.getFirstName());
        userResponse.setLastName(userRequest.getLastName());
        
        String userId = UUID.randomUUID().toString();
        
        userResponse.setUserId(userId);
        
        if(user == null) user = new HashMap();
        user.put(userId, userResponse);
        
        return new ResponseEntity(userResponse, HttpStatus.CREATED); 
    }
    
    @GetMapping(path = "/{userId}",
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
        })
    public ResponseEntity<UserResponse> getUserById(@PathVariable String userId) {
        
        if(user.containsKey(userId)){
            return new ResponseEntity(user.get(userId), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        // "Called get user";
    }
    
    @PutMapping
    public String updateUser() {
        return "Called update user";
    }
    
    @DeleteMapping
    public String deleteUser() {
        return "Called deleting user";
    }
}
