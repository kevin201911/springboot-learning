package com.mscloudmesh.springbootmongodbsharding.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * @Description: mongoConfig
 * @author kevin
 * @Date 2019/12/14
 */
@Configuration
public class MongoConfig {

    @Autowired
    private MongoBaseConfiguration baseConfiguration;
    
     @Autowired
     private MongoWarnConfiguration warnConfiguration;
    
    
    /**
     *@Description: MongoDbFactory
     * @author kevin
     * @Date 2019/12/14
     *@param config
     *@return
     *@throws Exception
     */
    @Bean
    public MongoDbFactory mongoDbFactory(MongoConfiguration  config) throws Exception {
        MongoClientURI uri = new MongoClientURI(config.getUri());
        MongoClient mongoClient = new MongoClient(uri);
        
        MongoDbFactory dbFactory = new SimpleMongoDbFactory(mongoClient, config.getDatabase());
        return dbFactory;
    }
    @Primary
    @Bean(name="baseMongoTemplate")
    public MongoTemplate baseMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(baseConfiguration));
    }
    
    
    @Bean(name="warnMongoTemplate")
    public MongoTemplate warnMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(warnConfiguration));
    }
}