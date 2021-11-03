package com.bobo.blog.common.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description 首页展示的博客信息
 * @Date 2021/11/1 18:31
 * @Created by bobo
 */
@Data
public class BlogIndexPageDto {
    private Long blogId;
    private String blogTitle;
    private String blogPreface;
    private Date createTime;
}
