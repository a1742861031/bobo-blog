package com.bobo.blog.common.entity.dto;

import lombok.Data;

/**
 * @Description 查询博客
 * @Date 2021/10/29 12:37
 * @Created by bobo
 */
@Data
public class BlogQuery {
    Integer categoryId;
    String blogTitle;
}
