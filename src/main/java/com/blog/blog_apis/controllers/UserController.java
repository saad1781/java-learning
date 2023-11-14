package com.blog.blog_apis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_apis.payloads.ApiResponse;
import com.blog.blog_apis.payloads.UserDto;
import com.blog.blog_apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // post
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
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
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> DeleteUser(@PathVariable int userId) {
        return new ResponseEntity<>(new ApiResponse<>("User Deleted successfully", true), HttpStatus.OK);
    }

    // get-get user
    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        return new ResponseEntity<ApiResponse<List<UserDto>>>(
                new ApiResponse<>("Users Fetched successfully", true, this.userService.getAllUsers()), null, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable int userId) {
        return new ResponseEntity<ApiResponse<UserDto>>(
                new ApiResponse<>("Users Fetched successfully", true, this.userService.getUserById(userId)), null, HttpStatusCode.valueOf(200));
    }
}
