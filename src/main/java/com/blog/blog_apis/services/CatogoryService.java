package com.blog.blog_apis.services;

import org.springframework.stereotype.Service;

import com.blog.blog_apis.entities.Catagory;
import com.blog.blog_apis.payloads.CatagoryDto;
import com.blog.blog_apis.repositories.CatagoryRepo;

@Service
public class CatogoryService extends BaseService<CatagoryRepo, Catagory, CatagoryDto> {

    public CatogoryService() {
        super(Catagory.class, CatagoryDto.class);
    }
    
}
