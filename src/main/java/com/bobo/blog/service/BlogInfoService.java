package com.bobo.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.blog.common.entity.dto.BlogQuery;
import com.bobo.blog.entity.BlogInfo;

/**
 * @Description 博客文章
 * @Date 2021/10/29 12:35
 * @Created by bobo
 */
public interface BlogInfoService {
    void getBlogList(Page<BlogInfo> page, BlogQuery query);
}
