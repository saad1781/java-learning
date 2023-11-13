package com.blog.blog_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_apis.payloads.ApiResponse;
import com.blog.blog_apis.payloads.UserDto;
import com.blog.blog_apis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // post
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    // put -update

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(@RequestBody UserDto userDto,
            @PathVariable("userId") int userid) {
                System.out.println(userid);
                System.out.println("\n\n\n\n\n");
        return new ResponseEntity<ApiResponse<UserDto>>(new ApiResponse<UserDto>("user Update successfully", true,
                this.userService.updateUser(userDto, userid)), HttpStatus.OK);
    }

    // delete- delete

    // get-get user
}
