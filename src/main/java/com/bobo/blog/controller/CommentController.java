package com.bobo.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.blog.common.entity.R;
import com.bobo.blog.entity.BlogComment;
import com.bobo.blog.service.BlogCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 评论控制器
 * @Date 2021/10/29 13:45
 * @Created by bobo
 */
@RestController
@Api(value = "博客评论", tags = {"博客评论"})
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    private BlogCommentService blogCommentService;

    @GetMapping(value = {"/query/{current}/{limit}", "/query/{current}/{limit}/{blogId}"})
    @ApiOperation("获取评论列表")
    public R getCommentList(@PathVariable Integer current, @PathVariable Integer limit, @PathVariable(required = false) Integer blogId) {
        Page<BlogComment> page = new Page<>(current, limit);
        blogCommentService.getCommentList(page, blogId);
        return R.ok().data("data", page);
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除评论")
    public R deleteComment(@PathVariable Integer id) {
        boolean result = blogCommentService.deleteComment(id);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/verify/{id}")
    @ApiOperation("审核评论")
    public R verifyComment(@PathVariable Integer id) {
        boolean result = blogCommentService.verifyComment(id);
        if (result) {
            return R.ok();
        }
        return R.error();
    }
}
