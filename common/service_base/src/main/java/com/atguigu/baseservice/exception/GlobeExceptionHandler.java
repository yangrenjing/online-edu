package com.atguigu.baseservice.exception;

import com.atguigu.util.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * @author Yangrj
 * @date 2020/5/5
 */
@ControllerAdvice
public class GlobeExceptionHandler {

    /*全局统一异常处理*/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error (Exception e) {
        e.printStackTrace();
        return R.error().message("执行了统一异常处理");
    }

    /*指定的异常处理*/
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error (ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了指定的异常处理方法");
    }

    /*自定义异常处理*/
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public R error (ServiceException e) {
        e.printStackTrace();
        return R.error().message(e.getMsg());
    }
}
