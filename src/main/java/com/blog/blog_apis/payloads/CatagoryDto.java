package com.blog.blog_apis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatagoryDto {
    @NotBlank()
    @Size(min = 4)
    private String title;

    @NotBlank()
    @Size(min = 10)
    private String description;
    private int id;
}
