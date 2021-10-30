package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bobo.blog.common.entity.dto.BlogListDto;
import com.bobo.blog.common.entity.dto.BlogQuery;
import com.bobo.blog.entity.BlogCategory;
import com.bobo.blog.entity.BlogInfo;
import com.bobo.blog.mapper.BlogCategoryMapper;
import com.bobo.blog.mapper.BlogInfoMapper;
import com.bobo.blog.mapper.BlogTagMapper;
import com.bobo.blog.service.BlogInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description blog文章实现类
 * @Date 2021/10/29 12:41
 * @Created by bobo
 */
public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;
    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public void getBlogList(Page<BlogInfo> page, BlogQuery query) {

        List<BlogListDto> blogListDtos = new ArrayList<>();
        QueryWrapper<BlogInfo> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(query.getBlogTitle())) {
            wrapper.like("blog_title", query.getBlogTitle());
        }
        if (query.getCategoryId() != null) {
            wrapper.eq("category_id", query.getCategoryId());
        }
        blogInfoMapper.selectPage(page, wrapper);
        List<BlogInfo> records = page.getRecords();
        for (BlogInfo record : records) {
            BlogListDto blogInfo = new BlogListDto();
            BeanUtils.copyProperties(blogInfo, record);
            //得到博客的分类
            BlogCategory category = blogCategoryMapper.selectById(record.getBlogCategoryId());
            blogInfo.setCategoryName(category.getCategoryName());
        }
    }
}
