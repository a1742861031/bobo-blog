package com.bobo.blog.common.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 用户信息dto
 * @Date 2021/10/30 12:07
 * @Created by bobo
 */
@Data
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nickName;
    private String avatar;
    private String qq;
    private String email;
    private String github;
}
