package com.mscloudmesh.springbootrediscache.mapper;

import com.mscloudmesh.springbootrediscache.model.User;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @Author kevin
 * @Date 2019/12/03
 * @Version 1.0
 **/
public interface UserMapper {
    List<User> queryAll();

    User findUserById(int id);

    int updateUser(@Param("user") User user);

    int deleteUserById(int id);
}
