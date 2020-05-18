package com.atguigu.eduservice.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author Yangrj
 * @date 2020/5/6
 */
@ApiModel(value = "用户的基本信息")
@Data
@Builder
public class UserInfoResult {

    @ApiModelProperty(value = "用户的名称")
    private String username;

    @ApiModelProperty(value = "用户的头像")
    private String avtar;

    @ApiModelProperty(value = "角色")
    private String roles;
}
