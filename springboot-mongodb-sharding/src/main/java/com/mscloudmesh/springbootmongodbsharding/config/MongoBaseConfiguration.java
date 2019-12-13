package com.mscloudmesh.springbootmongodbsharding.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: mongo配置类
 * @Author:杨攀
 * @Since:2019年7月8日上午11:19:39
 */
@ConfigurationProperties(prefix = "topinfo.mongodb.base")
@Component
public class MongoBaseConfiguration extends MongoConfiguration {
 
    

}