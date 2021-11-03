package com.bobo.blog.controller;

import com.bobo.blog.common.entity.R;
import com.bobo.blog.common.entity.dto.BlogIndexPageDto;
import com.bobo.blog.common.entity.dto.IndexPageDataDto;
import com.bobo.blog.entity.AdminUser;
import com.bobo.blog.service.AdminUserService;
import com.bobo.blog.service.BlogInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description 首页数据展示
 * @Date 2021/11/1 18:51
 * @Created by bobo
 */
@RestController
@RequestMapping("/admin/index")
@Api(value = "首页数据展示", tags = {"首页数据展示"})
public class ProfileController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private BlogInfoService blogInfoService;

    @ApiOperation("后台主页相关数据展示")
    @GetMapping("/index")
    public R getIndexData() {
        IndexPageDataDto indexPage = adminUserService.getIndexPage();
        return R.ok().data("item", indexPage);
    }

    @ApiOperation("展示几条前面的博客记录")
    @GetMapping("/index/blog/{limit}")
    public R getLimitBlogInfo(@PathVariable Integer limit) {
        List<BlogIndexPageDto> info = blogInfoService.getInfo(limit);
        return R.ok().data("item", info);
    }

    @ApiOperation("修改个人信息")
    @GetMapping("/editUserInfo")
    public R editUserInfo(HttpServletRequest request, AdminUser user ) {
        String token = request.getHeader("token");
        boolean result = adminUserService.editProfile(user, token );
        if (result) {
            return R.ok();
        }
        return R.error();
    }
}
