package com.bobo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bobo.blog.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 后台用户Mapper接口
 * @Date 2021/10/30 11:22
 * @Created by bobo
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {
}
