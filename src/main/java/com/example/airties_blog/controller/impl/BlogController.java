package com.example.airties_blog.controller.impl;

import com.example.airties_blog.business.abst.IBlogService;
import com.example.airties_blog.controller.abst.IBlogController;
import com.example.airties_blog.dto.BlogDto;

import lombok.AllArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Log4j2

@RestController
@RequestMapping("/blog")
public class BlogController implements IBlogController {

    private final IBlogService blogService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<BlogDto> createBlog(@RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.createBlog(blogDto));
    }

    @GetMapping("/get/{id}")
    @Override
    public ResponseEntity<BlogDto> getBlog(@PathVariable int id) {
        return ResponseEntity.ok(blogService.getBlogByBlogId(id));
    }

    @GetMapping("/get-all")
    @Override
    public ResponseEntity<List<BlogDto>> getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<BlogDto> updateBlog(@PathVariable int id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlog(id, blogDto));
    }

    @PutMapping("/update-header/{id}")
    @Override
    public ResponseEntity<BlogDto> updateBlogHeader(@PathVariable int id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlogHeader(id, blogDto));
    }

    @PutMapping("/update-content/{id}")
    @Override
    public ResponseEntity<BlogDto> updateBlogContent(@PathVariable int id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlogContent(id, blogDto));
    }

    @PutMapping("/update-image/{id}")
    @Override
    public ResponseEntity<BlogDto> updateBlogImage(@PathVariable int id, @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(blogService.updateBlogImage(id, blogDto));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<String> deleteBlog(@PathVariable int id) {
        return ResponseEntity.ok(blogService.deleteBlog(id));
    }
}
