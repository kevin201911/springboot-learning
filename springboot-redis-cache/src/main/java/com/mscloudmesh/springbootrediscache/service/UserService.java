package com.mscloudmesh.springbootrediscache.service;

import com.mscloudmesh.springbootrediscache.mapper.UserMapper;
import com.mscloudmesh.springbootrediscache.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 * @date 2019/12/03
 * @version 1.0
 */
public interface UserService {

    public List<User> queryAll();

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    public User findUserById(int id) ;

    /**
     * 更新用户
     *  先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    public int updateUser(User user) ;

    /**
     * 删除用户
     *  删除数据表中数据，然后删除缓存
     */
    public int deleteUserById(int id)  ;
}
