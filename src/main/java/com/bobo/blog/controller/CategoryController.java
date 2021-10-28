package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.entity.BlogCategory;
import com.bobo.blog.service.BlogCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 分类控制器
 * @Date 2021/10/28 19:51
 * @Created by bobo
 */
@RestController
@Api(value = "博客分类", tags = {"博客分类"})
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private BlogCategoryService blogCategoryService;

    @ApiOperation("获取博客列表")
    @GetMapping(value = {"/list", "list/{name}"})
    public R getCategoryList(@PathVariable(required = false) String name) {
        List<BlogCategory> categoryList = blogCategoryService.getCategoryList(name);
        return R.ok().data("list", categoryList);
    }

    @ApiOperation("修改分类信息")
    @PutMapping("")
    public R updateCategory(@RequestBody BlogCategory blogCategory) {
        boolean result = blogCategoryService.updateCategory(blogCategory);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("添加分类")
    @PostMapping()
    public R addCategory(@RequestBody BlogCategory blogCategory) {
        boolean result = blogCategoryService.addCategory(blogCategory);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("删除分类")
    @DeleteMapping("{id}")
    public R deleteCategory(@PathVariable Integer id) {
        boolean result = blogCategoryService.deleteCategory(id);
        if (result) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation("根据id获取分类信息")
    @GetMapping("{id}")
    public R getCategoryById(@PathVariable Integer id) {
        BlogCategory category = blogCategoryService.getCategoryById(id);
        return R.ok().data("item", category);
    }
}
