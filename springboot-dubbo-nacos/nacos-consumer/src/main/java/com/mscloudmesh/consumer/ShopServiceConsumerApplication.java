package com.mscloudmesh.consumer;


import com.mscloudmesh.provider.service.RpcShopService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 把主类和controller写在一起，方便简单测试演示。
 * @author kevin
 * @Date 2019/12/23
 * @Version 1.0
 */
@SpringBootApplication
@RestController
public class ShopServiceConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShopServiceConsumerApplication.class, args);
    }

}
