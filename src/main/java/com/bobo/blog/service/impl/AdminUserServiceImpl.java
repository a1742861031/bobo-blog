package com.bobo.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bobo.blog.common.entity.dto.UserDto;
import com.bobo.blog.common.entity.dto.UserInfoDto;
import com.bobo.blog.common.utils.TokenUtils;
import com.bobo.blog.entity.AdminUser;
import com.bobo.blog.mapper.AdminUserMapper;
import com.bobo.blog.service.AdminUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Description 后台管理用户service
 * @Date 2021/10/30 11:23
 * @Created by bobo
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper userMapper;

    @Override
    public boolean login(UserDto user) {
        QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
        wrapper.eq("login_user_name", user.getUsername());
        AdminUser adminUser = userMapper.selectOne(wrapper);
        if (adminUser == null) {
            return false;
        } else {
            String encode = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            return encode.equals(adminUser.getLoginPassword());
        }
    }

    @Override
    public UserInfoDto getUserInfo(String token) {
        String username = TokenUtils.getClaimInfo(token);
        if (StringUtils.isNotEmpty(username)) {
            QueryWrapper<AdminUser> wrapper = new QueryWrapper<>();
            wrapper.eq("login_user_name", username);
            AdminUser adminUser = userMapper.selectOne(wrapper);
            UserInfoDto userInfoDto = new UserInfoDto();
            BeanUtils.copyProperties(adminUser, userInfoDto);
            return userInfoDto;
        } else {
            return null;
        }
    }
}