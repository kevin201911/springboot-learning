package com.mscloudmesh.order;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mscloudmesh.order.mapper")
@DubboComponentScan(basePackages = "com.mscloudmesh.order.dubbo")
@ComponentScan(basePackages={"com.mscloudmesh.order","com.mscloudmesh.common"})
public class SpringbootDubboOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboOrderApplication.class, args);
    }

}
