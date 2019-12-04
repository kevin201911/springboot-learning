package com.mscloudmesh.springbootrediscache.model;

import lombok.Data;

/**
 * 用户实体类
 *
 * @Author kevin$
 * @Date 2019/12/03$
 * @Version 1.0
 **/

@Data
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String password;

    private Integer age;
}
