package com.blog.blog_apis.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog_apis.entities.Catagory;
import com.blog.blog_apis.entities.Post;
import com.blog.blog_apis.entities.User;
import com.blog.blog_apis.exceptions.ResourceNotFoundException;
import com.blog.blog_apis.payloads.CreatePostDto;
import com.blog.blog_apis.repositories.CatagoryRepo;
import com.blog.blog_apis.repositories.PostRepo;
import com.blog.blog_apis.repositories.UserRepo;

@Service()
public class PostService extends BaseService<PostRepo, Post, Post> {
    public PostService() {
        super(Post.class, Post.class);
    }

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CatagoryRepo catagoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Post createPost(CreatePostDto createPostDto) {
        Post post = new Post();
        long userId = Long.valueOf(createPostDto.getUser());
        post.setUser(this.userRepo.findById(createPostDto.getUser())
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId)));
        long catId = Long.valueOf(createPostDto.getCatagory());
        post.setCatagory(this.catagoryRepo.findById(createPostDto.getCatagory())
                .orElseThrow(() -> new ResourceNotFoundException("catagory", "id", catId)));
        this.modelMapper.map(createPostDto, post);

        return this.create(post);
    }

}
