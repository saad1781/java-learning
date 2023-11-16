package com.blog.blog_apis.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blog_apis.entities.Post;
import com.blog.blog_apis.payloads.CreatePostDto;
import com.blog.blog_apis.repositories.PostRepo;

@Service()
public class PostService extends BaseService<PostRepo, Post, Post> {
    public PostService() {
        super(Post.class, Post.class);
    }

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Post createPost(CreatePostDto createPostDto) {
        Post post = new Post();
        this.modelMapper.map(createPostDto, post);

        return this.create(post);
    }

}
