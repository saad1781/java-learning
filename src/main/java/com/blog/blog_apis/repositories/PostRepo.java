package com.blog.blog_apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_apis.entities.Catagory;
import com.blog.blog_apis.entities.Post;
import com.blog.blog_apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCatagory(Catagory catagory);
}
