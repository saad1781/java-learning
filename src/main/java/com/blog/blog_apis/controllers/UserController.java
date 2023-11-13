package com.blog.blog_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_apis.payloads.UserDto;
import com.blog.blog_apis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // post
    @PostMapping("/")
    public UserDto createUser(@RequestBody UserDto userDto){
        return this.userService.createUser(userDto);
    }

    // put -update

    // delete- delete

    // get-get user
}
