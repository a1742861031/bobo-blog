package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.common.entity.dto.UserDto;
import com.bobo.blog.common.entity.dto.UserInfoDto;
import com.bobo.blog.common.utils.TokenUtils;
import com.bobo.blog.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 管理员用户控制类
 * @Date 2021/10/30 10:42
 * @Created by bobo
 */
@RestController
@RequestMapping("/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping(value = "/login")
    public R login(@RequestBody UserDto user) {
        boolean result = adminUserService.login(user);
        if (result) {
            String sign = TokenUtils.sign(user.getUsername());
            return R.ok().message("登录成功").data("token", sign);
        } else {
            return R.error().message("登录失败账号或密码错误");
        }
    }

    @GetMapping("/getUerInfo")
    public R getUserInfo(HttpServletRequest request) {
        String token = request.getQueryString();
        String substring = token.substring(6);
        UserInfoDto userInfo = adminUserService.getUserInfo(substring);
        if (userInfo != null) {
            return R.ok().data("user", userInfo);
        } else {
            return R.error().message("获取用户信息失败");
        }

    }
}
