package com.mscloudmesh.springbootmongodbsharding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "topinfo.mongodb.warn")
@Component
public class MongoWarnConfiguration extends MongoConfiguration {


}