package com.mscloudmesh.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 
 * @ClassName:  DubboConsumerApplication   
 * @Description:消费者
 * @author kevin
 * @date: 2020/1/1
 */
@SpringBootApplication
@EnableHystrix //Hystrix断路器
public class DubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args); 
	}

}
