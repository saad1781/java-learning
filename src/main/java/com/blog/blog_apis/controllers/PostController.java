package com.blog.blog_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_apis.entities.Post;
import com.blog.blog_apis.payloads.CreatePostDto;
import com.blog.blog_apis.services.PostService;

@RestController()
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    
    @PostMapping("/")
    Post createPost(@RequestBody() CreatePostDto dto){
        return postService.createPost(dto);
    }
}
