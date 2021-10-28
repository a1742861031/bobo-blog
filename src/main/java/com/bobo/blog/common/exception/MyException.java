package com.bobo.blog.common.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 自定义异常
 * @author: bobo
 * @create: 2021-08-28 17:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor


public class MyException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;
}
