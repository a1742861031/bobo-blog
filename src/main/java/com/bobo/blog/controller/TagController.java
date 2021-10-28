package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.entity.BlogTag;
import com.bobo.blog.service.BlogTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description Tag控制器
 * @Date 2021/10/28 21:54
 * @Created by bobo
 */
@RestController
@Api(value = "博客分类", tags = {"博客标签"})
@RequestMapping("/admin/tag")
public class TagController {
    @Autowired
    private BlogTagService blogTagService;

    @ApiOperation("获取标签列表")
    @GetMapping(value = {"/list", "list/{name}"})
    public R getCategoryList(@PathVariable(required = false) String name) {
        System.out.println(name);
        List<BlogTag> tags = blogTagService.getTagList(name);
        return R.ok().data("list", tags);
    }

    @ApiOperation("修改标签信息")
    @PutMapping("")
    public R updateCategory(@RequestBody BlogTag blogTag) {
        boolean result = blogTagService.updateTag(blogTag);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("添加标签")
    @PostMapping()
    public R addCategory(@RequestBody BlogTag blogTag) {
        boolean result = blogTagService.addTag(blogTag);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("删除标签")
    @DeleteMapping("{id}")
    public R deleteCategory(@PathVariable Integer id) {
        boolean result = blogTagService.deleteTag(id);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("根据id获取标签信息")
    @GetMapping("{id}")
    public R getCategoryById(@PathVariable Integer id) {
        BlogTag tag = blogTagService.getTagById(id);
        return R.ok().data("item", tag);
    }
}

