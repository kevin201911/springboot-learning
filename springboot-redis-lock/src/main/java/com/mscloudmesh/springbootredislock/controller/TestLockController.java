package com.mscloudmesh.springbootredislock.controller;

import com.mscloudmesh.springbootredislock.lock.DistributedLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author kevin
 * @Date 2019/12/04
 * @Version 1.0
 **/

@Controller
@RequestMapping("test")
public class TestLockController {



    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("/lock")
    public void test() throws InterruptedException {
        int count = 10;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(() -> {
                try {
                    String lockKey = "17631701110";
                    distributedLocker.tryLock(lockKey, TimeUnit.SECONDS, 100, 8);
                    System.out.println("===加锁===" + Thread.currentThread().getName());

                    System.out.println("===做自己操作===");
                    Thread.sleep(5000);

                    System.out.println("===释放锁===" + Thread.currentThread().getName());
                    distributedLocker.unlock(lockKey);

                    System.out.println(latch.getCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
            thread.start();

        }
        latch.await();

    }

}
