package com.mscloudmesh.sprinbootrabbitmqdelay.controller;

import com.mscloudmesh.sprinbootrabbitmqdelay.config.RabbitConfig;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sun.tools.doclint.Entity.trade;

/**
 * @Author $
 * @Date $
 * @Version 1.0
 **/

@RestController
public class SenderController {


    @Autowired
    RabbitTemplate rabbitTemplate;


    @RequestMapping("/send")
    public void send(){
        // 通过广播模式发布延时消息 延时30分钟 持久化消息 消费后销毁 这里无需指定路由，会广播至每个绑定此交换机的队列
        rabbitTemplate.convertAndSend(RabbitConfig.Delay_Exchange_Name, "", "0001", message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            message.getMessageProperties().setDelay(1 * (60 * 1000));   // 毫秒为单位，指定此消息的延时时长
            return message;
        });
    }



}
