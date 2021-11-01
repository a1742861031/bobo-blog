package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.blog.entity.BlogComment;
import com.bobo.blog.mapper.BlogCommentMapper;
import com.bobo.blog.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 博客评论
 * @Date 2021/10/29 13:25
 * @Created by bobo
 */
@Service
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @Override
    public void getCommentList(Page<BlogComment> page, Integer blogId) {
        QueryWrapper<BlogComment> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("comment_id");
        wrapper.orderByDesc("blog_id");
        if (blogId != null) {
            wrapper.eq("blog_id", blogId);
        }
        blogCommentMapper.selectPage(page, wrapper);
    }

    @Override
    public boolean deleteComment(Integer id) {
        int delete = blogCommentMapper.deleteById(id);
        return delete >= 1;
    }

    @Override
    public boolean verifyComment(Integer id) {
        BlogComment comment = blogCommentMapper.selectById(id);
        if (comment.getCommentStatus() == 1) {
            comment.setCommentStatus(0);
        } else {
            comment.setCommentStatus(1);
        }
        int verify = blogCommentMapper.updateById(comment);
        return verify >= 1;
    }

    @Override
    public boolean modifyComment(BlogComment blogComment) {
        int update = blogCommentMapper.updateById(blogComment);
        return update >= 1;
    }
}
