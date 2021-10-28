package com.bobo.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 博客分类
 * </p>
 *
 * @author: bobo
 * @since 2021-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogCategory implements Serializable {

private static final long serialVersionUID=1L;
    /**
     * 分类表主键
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类的名称
     */
    @TableField("category_name")
    private String categoryName;

    /**
     * 分类的图标
     */
    @TableField("category_icon")
    private String categoryIcon;

    /**
     * 分类的排序值 被使用的越多数值越大
     */
    @TableField("category_rank")
    private Integer categoryRank;


    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
}
