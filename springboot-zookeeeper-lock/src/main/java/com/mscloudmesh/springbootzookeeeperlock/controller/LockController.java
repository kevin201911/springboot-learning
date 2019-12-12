package com.mscloudmesh.springbootzookeeeperlock.controller;

import com.mscloudmesh.springbootzookeeeperlock.vo.GlobalResponse;
import com.mscloudmesh.springbootzookeeeperlock.vo.ResultVo;
import com.mscloudmesh.springbootzookeeeperlock.zookeeper.DistributedLockByZookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class LockController {

    @Autowired
    private DistributedLockByZookeeper distributedLockByZookeeper;

    private final static String PATH = "test";

    @GetMapping("/lock1")
    public ResultVo<Boolean> getLock1() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        return GlobalResponse.makeOKRsp(flag);
    }

    @GetMapping("/lock2")
    public ResultVo getLock2() {
        Boolean flag;
        distributedLockByZookeeper.acquireDistributedLock(PATH);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        }
        flag = distributedLockByZookeeper.releaseDistributedLock(PATH);
        return GlobalResponse.makeOKRsp(flag);
    }
}
