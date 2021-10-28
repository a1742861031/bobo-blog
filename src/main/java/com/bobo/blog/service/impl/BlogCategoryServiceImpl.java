package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.blog.entity.BlogCategory;
import com.bobo.blog.mapper.BlogCategoryMapper;
import com.bobo.blog.service.BlogCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description 博客分类实现类
 * @Date 2021/10/28 20:08
 * @Created by bobo
 */
@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory> implements BlogCategoryService {
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public List<BlogCategory> getCategoryList(String name) {
        QueryWrapper<BlogCategory> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("category_rank");
        System.out.println(StringUtils.isNotEmpty(name));
        if (StringUtils.isNotEmpty(name)) {
            wrapper.like("category_name", name);
        }
        return blogCategoryMapper.selectList(wrapper);
    }

    @Override
    public boolean updateCategory(BlogCategory blogCategory) {
        int update = blogCategoryMapper.updateById(blogCategory);
        return update >= 1;
    }

    @Override
    public boolean addCategory(BlogCategory blogCategory) {
        blogCategory.setCreateTime(new Date());
        int insert = blogCategoryMapper.insert(blogCategory);
        return insert >= 1;
    }

    @Override
    public boolean deleteCategory(Integer id) {
        int delete = blogCategoryMapper.deleteById(id);
        return delete >= 1;
    }

    @Override
    public BlogCategory getCategoryById(Integer id) {
        return blogCategoryMapper.selectById(id);
    }
}
