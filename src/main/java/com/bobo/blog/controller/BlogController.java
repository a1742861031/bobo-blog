package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.common.entity.dto.BlogListDto;
import com.bobo.blog.common.entity.dto.BlogPostDto;
import com.bobo.blog.common.entity.dto.BlogQueryDto;
import com.bobo.blog.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 博客控制器
 * @Date 2021/10/31 20:58
 * @Created by bobo
 */
@RestController
@Api(value = "文章管理", tags = {"文章管理"})
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    private BlogInfoService blogInfoService;

    @PostMapping
    @ApiOperation("提交文章编辑")
    public R postBlog(@RequestBody BlogPostDto blog) {
        boolean result = blogInfoService.postBlog(blog);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/list")
    @ApiOperation("获取博客列表")
    public R getBlogList(@Nullable BlogQueryDto query) {
        List<BlogListDto> blogList = blogInfoService.getBlogList(query);
        return R.ok().data("items", blogList);
    }

    @DeleteMapping("{blogId}")
    @ApiOperation("删除博客")
    public R deleteBlog(@PathVariable Integer blogId) {
        boolean result = blogInfoService.deleteBlog(blogId);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @PutMapping()
    @ApiOperation("修改博客信息")
    public R updateBlog(@RequestBody BlogPostDto blog) {
        boolean result = blogInfoService.updateBlog(blog);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("{id}")
    @ApiOperation("根据id获取博客信息")
    public R getBlogById(@PathVariable Integer id) {
        BlogPostDto item = blogInfoService.getBlogById(id);
        return R.ok().data("item", item);
    }

    @GetMapping("/name/{id}")
    @ApiOperation("获取博客名")
    public R getBlogName(@PathVariable Integer id) {
        String name = blogInfoService.getBlogNameById(id);
        return R.ok().data("blogName", name);
    }

}
