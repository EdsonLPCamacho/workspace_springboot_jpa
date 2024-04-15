package com.webdevelopment.development.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdevelopment.development.entity.User;
import com.webdevelopment.development.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findUsers() {
        List<User> userList = userService.findAll();
        return ResponseEntity.ok().body(userList);
    }
}
