package com.mscloudmesh.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**

  * @Description: 配置中心 添加注解@EnableConfigServer
  * @author kevin
  * @date 2019/1/2
  */
@SpringBootApplication
@EnableConfigServer
public class ConfigserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserviceApplication.class, args);
	}
}
