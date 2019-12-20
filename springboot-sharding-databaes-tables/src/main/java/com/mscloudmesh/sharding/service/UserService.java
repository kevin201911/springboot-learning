package com.mscloudmesh.sharding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mscloudmesh.sharding.entity.User;


import java.util.List;

/**
 * @Classname UserService
 * @Description 用户服务类
 * @author kevin
 * @Date 2019/12/18
 * @Version 1.0
 */
public interface UserService extends IService<User> {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(User entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}
