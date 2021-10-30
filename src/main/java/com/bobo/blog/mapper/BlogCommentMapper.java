package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 博客评论dao层
 * @Date 2021/10/29 13:20
 * @Created by bobo
 */
@Mapper
public interface BlogCommentMapper extends BaseMapper<BlogComment> {
}
