package com.atguigu.eduservice.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 讲师查询条件
 * @author Yangrj
 * @date 2020/5/17
 */
@Data
@ApiModel(value = "讲师列表查询条件")
public class TeacherQuery {

    @ApiModelProperty(value = "教师名称")
    private String name;

    @ApiModelProperty(value = "教师级别")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2020-05-17 00:00:00")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2020-05-17 00:00:00")
    private String end;
}
