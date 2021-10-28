package com.bobo.blog.service;

import com.bobo.blog.entity.BlogCategory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Date 2021/10/28 20:06
 * @Created by bobo
 */
@Service
public interface BlogCategoryService {
    //获取分类列表
    List<BlogCategory> getCategoryList(@Nullable String name);
    //修改分类
    boolean updateCategory(BlogCategory blogCategory);
    //添加分类
    boolean addCategory(BlogCategory blogCategory);
    //删除分类
    boolean deleteCategory(Integer id);
    //根据id获取分类信息
    BlogCategory getCategoryById(Integer id);
}
