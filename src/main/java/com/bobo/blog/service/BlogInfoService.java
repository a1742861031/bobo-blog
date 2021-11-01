package com.bobo.blog.service;

import com.bobo.blog.common.entity.dto.BlogIndexPageDto;
import com.bobo.blog.common.entity.dto.BlogListDto;
import com.bobo.blog.common.entity.dto.BlogPostDto;
import com.bobo.blog.common.entity.dto.BlogQueryDto;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @Description 博客文章
 * @Date 2021/10/29 12:35
 * @Created by bobo
 */
public interface BlogInfoService {
    List<BlogListDto> getBlogList(@Nullable BlogQueryDto query);

    boolean postBlog(BlogPostDto blog);

    boolean deleteBlog(Integer blogId);

    //修改文章
    boolean updateBlog(BlogPostDto blog);

    //根据id获取博客信息
    BlogPostDto getBlogById(Integer blogId);

    //获取前面几个博客的，供首页展示
    List<BlogIndexPageDto> getInfo(Integer limitCount);
    //根据id获取博客的名字
    String getBlogNameById(Integer blogId);
}
