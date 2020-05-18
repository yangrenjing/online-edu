package com.atguigu.eduservice.controller;


import com.atguigu.baseservice.exception.ServiceException;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.query.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.util.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Slf4j
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "获取所有的用户列表", notes = "无参")
    @GetMapping("findAll")
    public R findAll () {
        return R.ok().data(teacherService.list(null));
    }

    @ApiOperation(value = "根据ID删除讲师", notes = "参数ID为讲师的ID")
    @DeleteMapping("delete/{id}")
    public R delete (@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        return R.ok().data(teacherService.removeById(id));
    }

    @ApiOperation(value = "获取讲师列表（分页）", notes = "查询条件")
    @PostMapping("page/{current}/{limit}")
    public R page(@ApiParam(name = "current", value = "当前页") @PathVariable Integer current,
                  @ApiParam(name = "limit", value = "每页记录数") @PathVariable Integer limit,
                  @ApiParam(name = "teacherQuery", value = "多条件查询") @RequestBody TeacherQuery teacherQuery) {
        Map<String, Object> result = new HashMap<>();
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);

        // 多条件查询
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        // 参数校验
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if(!StringUtils.isEmpty(level) && level != 0) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }
        //按照添加时间降序来排序记录
        wrapper.orderByDesc("gmt_create");
        teacherService.page(pageTeacher,wrapper);

        long total = pageTeacher.getTotal();
        List<EduTeacher> rows = pageTeacher.getRecords();
        result.put("total", total);
        result.put("rows", rows);
        return R.ok().data(result);
    }

    //添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping("save")
    public R addTeacher(@ApiParam(name = "eduTeacher", value = "讲师信息") @RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.save(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //修改讲师
    @ApiOperation(value = "修改讲师")
    @PostMapping("update")
    public R updateTeacher(@ApiParam(name = "eduTeacher", value = "讲师信息") @RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //根据讲师ID查询讲师
    @ApiOperation(value = "根据讲师ID查询讲师")
    @GetMapping("get/{id}")
    public R get(@ApiParam(name = "teacherId", value = "讲师ID", required = true) @PathVariable("id") String id){
        EduTeacher eduTeacher = teacherService.getById(id);
        return R.ok().data(eduTeacher);
    }
}

