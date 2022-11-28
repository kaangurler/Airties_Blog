package com.example.airties_blog.controller.abst;

import com.example.airties_blog.dto.BlogDto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogController {
    ResponseEntity<BlogDto> createBlog(BlogDto blogDto);
    ResponseEntity<BlogDto> getBlog(int id);
    ResponseEntity<List<BlogDto>> getAllBlogs();
    ResponseEntity<BlogDto> updateBlog(int id, BlogDto blogDto);
    ResponseEntity<BlogDto> updateBlogHeader(int id, BlogDto blogDto);
    ResponseEntity<BlogDto> updateBlogContent(int id, BlogDto blogDto);
    ResponseEntity<BlogDto> updateBlogImage(int id, BlogDto blogDto);
    ResponseEntity<String> deleteBlog(int id);
}
