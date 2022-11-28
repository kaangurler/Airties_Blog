package com.example.airties_blog.repository;

import com.example.airties_blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findBlogByBlogId(int blogId);

    List<Blog> findAll();

}
