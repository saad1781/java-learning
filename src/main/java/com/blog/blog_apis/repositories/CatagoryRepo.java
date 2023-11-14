package com.blog.blog_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blog_apis.entities.Catagory;


@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Integer>{
    
}
