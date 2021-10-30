package com.bobo.blog.common.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @Description 返回blog列表dto
 * @Date 2021/10/29 11:33
 * @Created by bobo
 */
@Data
public class BlogListDto {
    /**
     * 博客表主键id
     */
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;


    /**
     * 0-草稿 1-发布
     */
    private Integer blogStatus;


    /**
     * 阅读量
     */
    private Long blogViews;

    /**
     * 0-允许评论 1-不允许评论
     */
    @TableField("enable_comment")
    private Integer enableComment;

    /**
     * 是否删除 0=否 1=是
     */
    private Integer isDeleted;
    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 标签名称
     */
    private String tagName;
}
