package com.mscloudmesh.sprinbootkafka.controller;

import com.mscloudmesh.sprinbootkafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka功能
 *
 * @Author kevin$
 * @Date 2019/12/17$
 * @Version 1.0
 **/

@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @RequestMapping("/send")
    public String sendMsg(String msg){
        Long time=System.currentTimeMillis();
        kafkaService.sendMessage("topic1",String.valueOf(time)+":"+msg);

        return "success";
    }
}
