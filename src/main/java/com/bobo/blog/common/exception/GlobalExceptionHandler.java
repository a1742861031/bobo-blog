package com.bobo.blog.common.exception;

import com.bobo.blog.common.entity.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 处理全局异常
 * @Date 2021/10/15 20:27
 * @Created by bobo
 */
//@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        return R.error().message("服务端异常");
    }



    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e) {
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
