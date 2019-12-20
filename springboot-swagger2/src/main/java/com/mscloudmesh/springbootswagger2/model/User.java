package com.mscloudmesh.springbootswagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@ApiModel(value="用户信息",description="用户信息")
@Data
public class User {
    @ApiModelProperty(name = "id",value = "编号",required = true,example = "用户编号")
    private int id;

    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "用户名")
    private String username;

    @ApiModelProperty(name = "age",value = "年龄",required = true,example = "年龄")
    private int age;

}