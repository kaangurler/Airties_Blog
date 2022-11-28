package com.example.airties_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private int blogId;
    private String blogHeader;
    private String blogContent;
    private String blogImage;
    private Date dateCreation;
}
