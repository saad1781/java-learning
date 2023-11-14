package com.blog.blog_apis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    Long fieldValue;   


    public ResourceNotFoundException(String resourceName, String fieldName, Long id) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, id));
    }

}
