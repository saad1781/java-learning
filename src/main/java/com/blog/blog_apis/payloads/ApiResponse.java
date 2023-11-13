package com.blog.blog_apis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private Boolean success;
    private T data;

    // Constructors without data field
    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }
}
