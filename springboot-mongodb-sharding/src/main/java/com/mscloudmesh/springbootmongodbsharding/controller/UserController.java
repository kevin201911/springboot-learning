package com.mscloudmesh.springbootmongodbsharding.controller;

import com.mscloudmesh.springbootmongodbsharding.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kevin
 * @Date 2019/12/14
 **/

@RestController
public class UserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("save")
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        mongoTemplate.save(userInfo);
        return "success";
    }


    @GetMapping("getUserList")
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfoList = mongoTemplate.findAll(UserInfo.class);
        return userInfoList;
    }

}
