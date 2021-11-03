package com.bobo.blog.common.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description 提交文章
 * @Date 2021/10/31 21:03
 * @Created by bobo
 */
@Data
public class BlogPostDto {

    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;


    /**
     * 博客前言
     */
    private String blogPreface;

    /**
     * 博客内容
     */
    private String blogContent;

    /**
     * 博客分类id
     */
    private Integer blogCategoryId;


    /**
     * 0-草稿 1-发布
     */
    private Integer blogStatus;


    /**
     * 0-允许评论 1-不允许评论
     */
    private Integer enableComment;

    private List<Integer> tagIds;


}
