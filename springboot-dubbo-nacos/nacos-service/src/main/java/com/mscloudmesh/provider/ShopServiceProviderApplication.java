package com.mscloudmesh.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboConfigConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * dubbo 服务提供方
 * @author kevin
 * @Date 2019/12/23
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo
public class ShopServiceProviderApplication {

    //使用jar方式打包的启动方式
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException{
        SpringApplication.run(ShopServiceProviderApplication.class, args).registerShutdownHook();
        countDownLatch.await();
    }
}
