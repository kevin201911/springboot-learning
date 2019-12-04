package com.mscloudmesh.springbootrediscache.controller;

import com.mscloudmesh.springbootrediscache.model.User;
import com.mscloudmesh.springbootrediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存测试
 *
 * @Author kevin$
 * @Date 2019/12/03$
 * @Version 1.0
 **/
@Controller
@RequestMapping
public class RedisCacheTest {

    @Autowired
    private UserService userService;



    @ResponseBody
    @RequestMapping("/findByAll")
    public List<User> findByAll(){
        List<User> lists = userService.queryAll();
        return lists;
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam int id){
        User user = userService.findUserById(id);
        return user;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        int result = userService.updateUser(user);
        if(result != 0){
            return "更新成功";
        }
        return "更新失败";
    }

    @ResponseBody
    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "删除成功";
        }
        return "删除失败";
    }

}
