package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客分类 Mapper 接口
 * </p>
 *
 * @author bobo
 * @since 2021-10-28
 */
@Mapper
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {

}
