package com.blog.blog_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blog_apis.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
}
