package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description 查询blog信息
 * @Date 2021/10/29 12:31
 * @Created by bobo
 */
@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {
    int insertBlog(BlogInfo blogInfo);
    @Select("Select blog_title From tb_blog_info Where blog_id = #{blogId}")
    String getBlogName(Integer blogId);
}
