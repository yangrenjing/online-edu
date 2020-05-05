package com.atguigu.eduservice.controller;


import com.atguigu.baseservice.exception.ServiceException;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author YangRenJing
 * @since 2020-04-30
 */
@Api(value = "讲师管理",tags={"用户操作接口"})
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "获取所有的用户列表", notes = "无参")
    @GetMapping("findAll")
    public R findAll () {
        return R.ok().data(teacherService.list(null));
    }

    @ApiOperation(value = "根据ID删除讲师", notes = "参数ID为讲师的ID")
    @DeleteMapping("{id}")
    public R delete (@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        if (id.equals("1")) {
            throw new ServiceException(500, "自定义异常");
        }
        return R.ok().data(teacherService.removeById(id));
    }
}

