package com.mscloudmesh.springbootmongodb.controller;

import com.mscloudmesh.springbootmongodb.model.UserInfo;
import com.mscloudmesh.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("save")
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        userRepository.save(userInfo);
        return "success";
    }


    @GetMapping("getUserList")
    public List<UserInfo> getUserList(){
        List<UserInfo> userInfoList = userRepository.findAll();
        return userInfoList;
    }

    @GetMapping("delete")
    public String delete(Long id){
        userRepository.deleteById(id);
        return "success";
    }

    @GetMapping("update")
    public String update(Long id,String username,String password){
        UserInfo userInfo = new UserInfo(id,username,password);
        userRepository.save(userInfo);
        return "success";
    }
}

