package com.blog.blog_apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.blog.blog_apis.payloads.ApiResponse;
import com.blog.blog_apis.payloads.CatagoryDto;
import com.blog.blog_apis.services.CatogoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/catagory")
public class CatagoryController {
    @Autowired
    private CatogoryService catagoryService;

    // post
    @PostMapping("/")
    public ResponseEntity<CatagoryDto> createUser(@Valid @RequestBody CatagoryDto catagoryDto) {
        return new ResponseEntity<CatagoryDto>(this.catagoryService.create(catagoryDto), HttpStatus.CREATED);
    }

    // delete- delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCatagory(@PathVariable int id) {
        this.catagoryService.delete(id);
        return new ResponseEntity<>(new ApiResponse<>("Catagory Deleted successfully", true), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CatagoryDto>> updateCatagory(@RequestBody CatagoryDto catagoryDto,
            @PathVariable("id") int id) {
        catagoryDto.setId(id);
        return new ResponseEntity<ApiResponse<CatagoryDto>>(
                new ApiResponse<CatagoryDto>("user Update successfully", true,
                        this.catagoryService.update(catagoryDto, id)),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CatagoryDto>> getCatagoryById(@PathVariable Integer id) {
        return new ResponseEntity<ApiResponse<CatagoryDto>>(
                new ApiResponse<CatagoryDto>("Catagory Fetched Successfully", true,
                        this.catagoryService.getById(id)),
                HttpStatus.OK);
    }

   @GetMapping("/")
   public ResponseEntity<ApiResponse<List<CatagoryDto>>> getAllCatagories() {
        return new ResponseEntity<ApiResponse<List<CatagoryDto>>>(
                new ApiResponse<List<CatagoryDto>>("Catagories Fetched Successfully", true,
                        this.catagoryService.getAll()),
                HttpStatus.OK);
    }
}
