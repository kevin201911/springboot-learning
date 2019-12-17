package com.mscloudmesh.springbootmongodbsharding.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: mongo配置类
 * @author kevin
 * @Date 2019/12/14
 */
@ConfigurationProperties(prefix = "topinfo.mongodb.base")
@Component
public class MongoBaseConfiguration extends MongoConfiguration {
 
    

}