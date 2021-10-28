package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogTag;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 博客标签
 * @Date 2021/10/28 21:45
 * @Created by bobo
 */
@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTag> {
}
