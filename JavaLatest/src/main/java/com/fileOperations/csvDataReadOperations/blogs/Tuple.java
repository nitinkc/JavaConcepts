package com.fileOperations.csvDataReadOperations.blogs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author Created by nichaurasia
 * @create on Thursday, October/01/2020 at 1:22 AM
 */

@Getter
@ToString
@EqualsAndHashCode
public class Tuple {
    private final BlogPostType type;
    private final String author;

    public Tuple(BlogPostType type, String author) {
        this.type = type;
        this.author = author;
    }
}