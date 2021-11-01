package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.common.entity.dto.BlogIndexPageDto;
import com.bobo.blog.common.entity.dto.IndexPageDataDto;
import com.bobo.blog.common.entity.dto.UserDto;
import com.bobo.blog.common.entity.dto.UserInfoDto;
import com.bobo.blog.common.utils.TokenUtils;
import com.bobo.blog.service.AdminUserService;
import com.bobo.blog.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description 管理员用户控制类
 * @Date 2021/10/30 10:42
 * @Created by bobo
 */
@RestController
@Api(value = "管理员登录", tags = {"管理员登录"})
@RequestMapping("/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private BlogInfoService blogInfoService;


    @ApiOperation("管理员登录")
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

    @ApiOperation("获取管理员信息")
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
