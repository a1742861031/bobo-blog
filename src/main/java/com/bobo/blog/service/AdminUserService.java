package com.bobo.blog.service;

import com.bobo.blog.common.entity.dto.IndexPageDataDto;
import com.bobo.blog.common.entity.dto.UserDto;
import com.bobo.blog.common.entity.dto.UserInfoDto;
import com.bobo.blog.entity.AdminUser;

/**
 * @Description 后台管理用户接口
 * @Date 2021/10/30 11:24
 * @Created by bobo
 */
public interface AdminUserService {
    boolean login(UserDto user);

    UserInfoDto getUserInfo(String token);
    //后台首页数据展示
    IndexPageDataDto getIndexPage();
    //修改个人信息
    boolean editProfile(AdminUser user,String token);
}
