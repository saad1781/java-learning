package com.blog.blog_apis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostDto {
    private String title;
    private String content;
    private Integer catagory;
    private Integer user;
}
