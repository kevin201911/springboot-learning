package com.mscloudmesh.springbootrediscache.service.impl;

import com.mscloudmesh.springbootrediscache.mapper.UserMapper;
import com.mscloudmesh.springbootrediscache.model.User;
import com.mscloudmesh.springbootrediscache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户服务实现
 *
 * @Author kevin
 * @Date 2019/12/03
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    public User findUserById(int id) {
        String key = "user_" + id;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            log.info("==========从缓存中获得数据=========",user.getUserName());
            return user;
        } else {
            User user = userMapper.findUserById(id);
            log.info("==========从数据表中获得数据=========",user.getUserName());
            // 写入缓存
            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }

    }

    /**
     * 更新用户
     *  先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    public int updateUser(User user) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        int result = userMapper.updateUser(user);
        if (result != 0) {
            String key = "user_" + user.getId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                log.info("删除缓存中的key=========>", key);
            }
            // 再将更新后的数据加入缓存
            User userNew = userMapper.findUserById(user.getId());
            if (userNew != null) {
                operations.set(key, userNew, 3, TimeUnit.HOURS);
            }
        }
        return result;
    }

    /**
     * 删除用户
     *  删除数据表中数据，然后删除缓存
     */
    public int deleteUserById(int id) {
        int result = userMapper.deleteUserById(id);
        String key = "user_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                log.info("删除了缓存中的key:", key);
            }
        }
        return result;
    }

}
