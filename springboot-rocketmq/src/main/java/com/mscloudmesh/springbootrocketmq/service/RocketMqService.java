package com.mscloudmesh.springbootrocketmq.service;

import org.apache.rocketmq.client.producer.SendResult;

public interface RocketMqService {
    SendResult openAccountMsg(String msgInfo) ;
}
