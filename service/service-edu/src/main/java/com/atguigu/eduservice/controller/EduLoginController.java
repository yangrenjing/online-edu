package com.atguigu.eduservice.controller;

import com.atguigu.eduservice.entity.response.UserInfoResult;
import com.atguigu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yangrj
 * @date 2020/5/6
 */
@Api(value = "登陆管理", tags = {"登陆操作接口"})
@RestController
@RequestMapping("/eduservice/user")
@Slf4j
@CrossOrigin // 跨域处理
public class EduLoginController {

    @ApiOperation(value = "用户登陆接口", notes = "用户的账号密码")
    @PostMapping("login")
    public R login() {
        Map<String, Object> result = new HashMap<>();
        result.put("token", "admin");
        return R.ok().data(result);
    }

    @ApiOperation(value = "获取用户的信息", notes = "需要带请求的token")
    @GetMapping("get/info")
    public R getInfo() {
        UserInfoResult info = UserInfoResult.builder()
                .avtar("https://v1.qqhot.com/avatar/202005/13/14/52/5ebb992cd54d7997.jpg!200x200.jpg")
                .username("杨测试")
                .roles("[admin]")
                .build();
        return R.ok().data(info);
    }


}
