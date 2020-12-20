package com.nitin.blogs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Created by nichaurasia
 * @create on Thursday, October/01/2020 at 1:20 AM
 */

@Getter
@Setter
@ToString
public class BlogPost {
    private String title;
    private String author;
    private BlogPostType type;
    private int likes;

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }
}