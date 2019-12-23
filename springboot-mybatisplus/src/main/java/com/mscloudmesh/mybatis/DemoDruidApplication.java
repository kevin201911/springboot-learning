package com.mscloudmesh.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: kevin
 * @Date: 2019/12/23
 */
@SpringBootApplication
@MapperScan("com.mscloudmesh.mybatis.mapper")
public class DemoDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDruidApplication.class, args);
    }

}
