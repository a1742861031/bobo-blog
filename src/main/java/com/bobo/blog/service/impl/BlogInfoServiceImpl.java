package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bobo.blog.common.entity.dto.BlogIndexPageDto;
import com.bobo.blog.common.entity.dto.BlogListDto;
import com.bobo.blog.common.entity.dto.BlogPostDto;
import com.bobo.blog.common.entity.dto.BlogQueryDto;
import com.bobo.blog.entity.BlogInfo;
import com.bobo.blog.entity.BlogTagRelation;
import com.bobo.blog.mapper.BlogCategoryMapper;
import com.bobo.blog.mapper.BlogInfoMapper;
import com.bobo.blog.mapper.BlogTagRelationMapper;
import com.bobo.blog.service.BlogInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description blog文章实现类
 * @Date 2021/10/29 12:41
 * @Created by bobo
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Override
    public List<BlogListDto> getBlogList(BlogQueryDto query) {
        List<BlogListDto> list = new ArrayList<>();
        QueryWrapper<BlogInfo> wrapper = new QueryWrapper<>();
        if (query != null) {
            if (query.getCategoryId() != null) {
                wrapper.eq("blog_category_id", query.getCategoryId());
            }
            if (StringUtils.isNotEmpty(query.getBlogTitle())) {
                wrapper.like("blogTitle", query.getBlogTitle());
            }
        }
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(wrapper);
        for (BlogInfo blogInfo : blogInfos) {
            BlogListDto blogListDto = new BlogListDto();
            BeanUtils.copyProperties(blogInfo, blogListDto);
            QueryWrapper<BlogTagRelation> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("blog_id", blogInfo.getBlogId());
            List<BlogTagRelation> tagRelations = blogTagRelationMapper.selectList(wrapper1);
            ArrayList<Integer> tagIds = new ArrayList<>();
            for (BlogTagRelation tagRelation : tagRelations) {
                tagIds.add(tagRelation.getTagId());
            }
            blogListDto.setTagIds(tagIds);
            list.add(blogListDto);
        }
        return list;
    }

    @Override
    @Transactional
    public boolean postBlog(BlogPostDto blog) {
        //新增文章
        System.out.println(blog);
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(blog, blogInfo);
        //在文章表中添加
        long insertId = blogInfoMapper.insertBlog(blogInfo);
        //tag文章关系表中添加
        for (Integer tagId : blog.getTagIds()) {
            BlogTagRelation blogTagRelation = new BlogTagRelation();
            blogTagRelation.setTagId(tagId);
            blogTagRelation.setBlogId(insertId);
            blogTagRelationMapper.insert(blogTagRelation);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deleteBlog(Integer blogId) {
        blogInfoMapper.deleteById(blogId);
        QueryWrapper<BlogTagRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id", blogId);
        blogTagRelationMapper.delete(wrapper);
        return true;
    }

    @Override
    @Transactional
    public boolean updateBlog(BlogPostDto blog) {
        //修改文章
        BlogInfo blogInfo = new BlogInfo();
        BeanUtils.copyProperties(blog, blogInfo);
        System.out.println(blog);
        blogInfoMapper.updateById(blogInfo);
        QueryWrapper<BlogTagRelation> wrapper = new QueryWrapper<>();
        //删除以前的旧关系
        wrapper.eq("blog_id", blog.getBlogId());
        blogTagRelationMapper.delete(wrapper);
        for (Integer tagId : blog.getTagIds()) {
            BlogTagRelation blogTagRelation = new BlogTagRelation();
            blogTagRelation.setBlogId(blog.getBlogId());
            blogTagRelation.setTagId(tagId);
            blogTagRelation.setCreateTime(new Date());
            blogTagRelationMapper.insert(blogTagRelation);
        }
        return true;
    }

    @Override
    public BlogPostDto getBlogById(Integer blogId) {
        BlogPostDto blogPostDto = new BlogPostDto();
        BlogInfo blogInfo = blogInfoMapper.selectById(blogId);
        BeanUtils.copyProperties(blogInfo, blogPostDto);
        QueryWrapper<BlogTagRelation> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_id", blogId);
        List<BlogTagRelation> relations = blogTagRelationMapper.selectList(wrapper);
        List<Integer> tagIds = new ArrayList<>();
        for (BlogTagRelation relation : relations) {
            tagIds.add(relation.getTagId());
        }
        blogPostDto.setTagIds(tagIds);
        return blogPostDto;
    }

    @Override
    public List<BlogIndexPageDto> getInfo(Integer limitCount) {
        ArrayList<BlogIndexPageDto> list = new ArrayList<>();
        QueryWrapper<BlogInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        wrapper.last("limit" + " " + limitCount);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(wrapper);
        for (BlogInfo blogInfo : blogInfos) {
            BlogIndexPageDto blogIndexPageDto = new BlogIndexPageDto();
            BeanUtils.copyProperties(blogInfo, blogIndexPageDto);
            list.add(blogIndexPageDto);
        }
        return list;
    }

    @Override
    public String getBlogNameById(Integer blogId) {
       return blogInfoMapper.getBlogName(blogId);
    }
}
