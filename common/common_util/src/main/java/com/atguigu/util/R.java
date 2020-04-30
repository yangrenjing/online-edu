package com.atguigu.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author ：Yangrj
 * @date ：Created in 2020/4/30 17:01
 * @description：统一返回结果类
 * @version: 1.0$
 */
@ApiModel(value = "R对象", description = "统一返回结果类")
@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    /**
     * 私有化构造方法
     */
    private R(){};

    /**
     * 成功的静态方法
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("您的操作成功啦(*^▽^*)");
        return r;
    }

    /**
     * 失败的静态方法
     */
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("您的操作失败啦(⊙︿⊙)");
        return r;
    }

    /**
     * 链式编程
     */
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R data(Object data){
        this.setData(data);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
