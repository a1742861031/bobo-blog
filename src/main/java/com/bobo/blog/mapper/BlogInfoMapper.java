package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 查询blog信息
 * @Date 2021/10/29 12:31
 * @Created by bobo
 */
@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {

}
