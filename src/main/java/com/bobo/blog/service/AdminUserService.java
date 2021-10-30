package com.bobo.blog.service;

import com.bobo.blog.common.entity.dto.UserDto;
import com.bobo.blog.common.entity.dto.UserInfoDto;

/**
 * @Description 后台管理用户接口
 * @Date 2021/10/30 11:24
 * @Created by bobo
 */
public interface AdminUserService {
    boolean login(UserDto user);

    UserInfoDto getUserInfo(String token);
}
