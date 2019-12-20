package com.mscloudmesh.sharding.controller;


import com.mscloudmesh.sharding.entity.User;
import com.mscloudmesh.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**

 * @Description 用户测试控制类
 * @author kevin
 * @Date 2019/12/18
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public List<User> select() {
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public Boolean insert(User user) {
        return userService.save(user);
    }

}
