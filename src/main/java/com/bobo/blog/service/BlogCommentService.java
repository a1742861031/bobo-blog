package com.bobo.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.blog.entity.BlogCategory;
import com.bobo.blog.entity.BlogComment;
import org.springframework.lang.Nullable;

/**
 * @Description 博客评论
 * @Date 2021/10/29 13:19
 * @Created by bobo
 */

public interface BlogCommentService {
    //获取评论列表
    void getCommentList(Page<BlogComment> page, @Nullable Integer blogId);

    //删除评论
    boolean deleteComment(Integer id);

    //审核评论
    boolean verifyComment(Integer id);
    //修改
    boolean modifyComment(BlogComment blogComment);
}
