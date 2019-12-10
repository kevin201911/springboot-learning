package com.mscloudmesh.springbootredisqueue.receive;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Log
@Component
public class RedisMessageReceiver {
    @Autowired
    private CountDownLatch countDownLatch;

    public void receivedMsg(String msg) {
        log.info("received msg: " + msg);
        // 计数，减一
        countDownLatch.countDown();
    }
}