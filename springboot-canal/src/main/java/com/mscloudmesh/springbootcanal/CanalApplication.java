package com.mscloudmesh.springbootcanal;


import com.mscloudmesh.springbootcanal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 启动方法
 * 
 * @author  kevin

 */
@SpringBootApplication
@EnableCanalClient
public class CanalApplication {
	
	public static void main(String[] args){
        SpringApplication app = new SpringApplication(CanalApplication.class);
        app.run(args);
    }

}
