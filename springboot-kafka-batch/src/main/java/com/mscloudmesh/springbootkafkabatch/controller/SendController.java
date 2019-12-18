package com.mscloudmesh.springbootkafkabatch.controller;

import com.mscloudmesh.springbootkafkabatch.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author $
 * @Date $
 * @Version 1.0
 **/
@Controller
public class SendController {

    @Autowired
    private SendService sendService;

     @RequestMapping("/send")
    public String send(String msg){
        for(int i=0;i<10000;i++) {
            sendService.sendMessage(3, String.valueOf(i));
        }
        return "success";
    }
}
