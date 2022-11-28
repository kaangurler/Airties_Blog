package com.example.airties_blog.business.impl;

import com.example.airties_blog.bean.ModelMapperConfig;
import com.example.airties_blog.business.abst.IBlogService;

import com.example.airties_blog.dto.BlogDto;
import com.example.airties_blog.entity.Blog;
import com.example.airties_blog.repository.IBlogRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Log4j2

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;
    private final ModelMapperConfig modelMapperConfig;

    @Override
    public BlogDto mapToDto(Blog blog) {
        return modelMapperConfig.modelMapper().map(blog, BlogDto.class);
    }

    @Override
    public Blog mapToEntity(BlogDto blogDto) {
        return modelMapperConfig.modelMapper().map(blogDto, Blog.class);
    }

    @Override
    public BlogDto createBlog(BlogDto blogDto) {
        blogRepository.save(this.mapToEntity(blogDto));
        return blogDto;
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        return blogRepository.findAll().stream().map(blog -> this.mapToDto(blog)).collect(Collectors.toList());
    }

    @Override
    public BlogDto getBlogByBlogId(int blogId) {
        return this.mapToDto(blogRepository.findBlogByBlogId(blogId));
    }

    @Override
    public BlogDto updateBlog(int blogId, BlogDto blogDto) {
        Blog updateBlog = blogRepository.findBlogByBlogId(blogId);
        updateBlog.setBlogHeader(blogDto.getBlogHeader());
        updateBlog.setBlogContent(blogDto.getBlogContent());
        updateBlog.setBlogImage(blogDto.getBlogImage());
        return this.mapToDto(updateBlog);
    }

    @Override
    public BlogDto updateBlogHeader(int blogId, BlogDto blogDto) {
        Blog updateBlog = blogRepository.findBlogByBlogId(blogId);
        updateBlog.setBlogHeader(blogDto.getBlogHeader());
        return this.mapToDto(updateBlog);
    }

    @Override
    public BlogDto updateBlogContent(int blogId, BlogDto blogDto) {
        Blog updateBlog = blogRepository.findBlogByBlogId(blogId);
        updateBlog.setBlogContent(blogDto.getBlogContent());
        return this.mapToDto(updateBlog);
    }

    @Override
    public BlogDto updateBlogImage(int blogId, BlogDto blogDto) {
        Blog updateBlog = blogRepository.findBlogByBlogId(blogId);
        updateBlog.setBlogImage(blogDto.getBlogImage());
        return this.mapToDto(updateBlog);
    }

    @Override
    public String deleteBlog(int blogId) {
        Blog databaseBlog = blogRepository.findBlogByBlogId(blogId);
        if (databaseBlog == null){
            return "Index is empty";
        }
        blogRepository.delete(databaseBlog);
        return "Deleted";

    }
}
