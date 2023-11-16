package com.blog.blog_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_apis.entities.Post;
import com.blog.blog_apis.payloads.ApiResponse;
import com.blog.blog_apis.payloads.CreatePostDto;
import com.blog.blog_apis.services.PostService;

@RestController()
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/")
    Post createPost(@RequestBody() CreatePostDto dto) {
        return postService.createPost(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {
        this.postService.delete(id);
        return new ResponseEntity<>(new ApiResponse<>("Post Deleted successfully", true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>> getCatagoryById(@PathVariable Integer id) {
        return new ResponseEntity<ApiResponse<Post>>(
                new ApiResponse<Post>("Post Fetched Successfully", true,
                        this.postService.getById(id)),
                HttpStatus.OK);
    }
}
