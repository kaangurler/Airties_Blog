package com.example.airties_blog.business.abst;

import com.example.airties_blog.dto.BlogDto;
import com.example.airties_blog.entity.Blog;

import java.util.List;

public interface IBlogService {

    BlogDto mapToDto(Blog blog);
    Blog mapToEntity(BlogDto blogDto);
    BlogDto createBlog(BlogDto blogDto);
    List<BlogDto> getAllBlogs();
    BlogDto getBlogByBlogId(int blogId);
    BlogDto updateBlog(int blogId, BlogDto blogDto);
    BlogDto updateBlogHeader(int blogId, BlogDto blogDto);
    BlogDto updateBlogContent(int blogId, BlogDto blogDto);
    BlogDto updateBlogImage(int blogId, BlogDto blogDto);
    String deleteBlog(int blogId);

}
