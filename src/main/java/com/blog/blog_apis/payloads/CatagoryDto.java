package com.blog.blog_apis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatagoryDto {
    private String title;
    private String description;
    private int id;
}
