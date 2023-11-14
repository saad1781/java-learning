package com.blog.blog_apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.blog.blog_apis")
public class BlogApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApisApplication.class, args);
	}
}
