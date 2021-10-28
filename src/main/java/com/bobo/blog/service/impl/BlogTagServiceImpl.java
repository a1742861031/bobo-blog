package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bobo.blog.entity.BlogTag;
import com.bobo.blog.mapper.BlogTagMapper;
import com.bobo.blog.service.BlogTagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description tag接口实现
 * @Date 2021/10/28 21:46
 * @Created by bobo
 */
@Service
public class BlogTagServiceImpl implements BlogTagService {
    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public List<BlogTag> getTagList(String tagName) {
        QueryWrapper<BlogTag> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(tagName)) {
            wrapper.like("tag_name", tagName);
        }
        return blogTagMapper.selectList(wrapper);
    }

    @Override
    public boolean updateTag(BlogTag tag) {
        int update = blogTagMapper.updateById(tag);
        return update >= 1;
    }

    @Override
    public boolean addTag(BlogTag tag) {
        tag.setCreateTime(new Date());
        int insert = blogTagMapper.insert(tag);
        return insert >= 1;
    }

    @Override
    public boolean deleteTag(Integer id) {
        int delete = blogTagMapper.deleteById(id);
        return delete >= 1;
    }

    @Override
    public BlogTag getTagById(Integer id) {
        return blogTagMapper.selectById(id);
    }
}
