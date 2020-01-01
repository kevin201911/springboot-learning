package com.mscloudmesh.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 
 * @ClassName:  DubboProviderApplication   
 * @Description:服务提供者启动类
 * @author kevin
 * @date: 2020/1/1
 *
 */
@SpringBootApplication
@EnableHystrix //Hystrix断路器
public class DubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args); 
	}

}
