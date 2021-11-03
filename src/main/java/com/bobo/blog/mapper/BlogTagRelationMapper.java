package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogTagRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 博客标签关系表
 * @Date 2021/10/31 21:10
 * @Created by bobo
 */
@Mapper
public interface BlogTagRelationMapper extends BaseMapper<BlogTagRelation> {
}
