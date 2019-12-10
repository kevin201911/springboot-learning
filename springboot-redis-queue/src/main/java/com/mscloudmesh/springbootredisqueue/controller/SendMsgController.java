package com.mscloudmesh.springbootredisqueue.controller;

import com.mscloudmesh.springbootredisqueue.constants.GlobalConstant;

import com.mscloudmesh.springbootredisqueue.vo.GlobalResponse;
import com.mscloudmesh.springbootredisqueue.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * 发送消息
 *
 * @Author kevin$
 * @Date 2019/12/10$
 * @Version 1.0
 **/

@RestController
@RequestMapping("send")
public class SendMsgController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    CountDownLatch countDownLatch;

    @RequestMapping("{msg}")
    public ResultVo<String> send(@PathVariable String msg){
       try{
           redisTemplate.convertAndSend(GlobalConstant.MSG_TOPIC,msg);
           countDownLatch.countDown();

           return GlobalResponse.makeOKRsp("发送成功！");
       }catch (Exception e ){
           return GlobalResponse.makeErrRsp("发送失败");

       }

    }
}
