package com.mscloudmesh.storage;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.mscloudmesh.storage.mapper")
@DubboComponentScan(basePackages = "com.mscloudmesh.storage.dubbo")
@ComponentScan(basePackages={"com.mscloudmesh.storage","com.mscloudmesh.common"})
public class SpringbootDubboStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboStorageApplication.class, args);
    }

}
