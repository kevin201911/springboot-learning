package com.mscloudmesh.provider.service;

import java.util.Random;

import com.mscloudmesh.service.DefaultApiService;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 
 * @ClassName: DefaultDemoService
 * @ 接口实现类
 * @author kevin
 * @date: 2020/1/1
 *
 */
@Service // dubbo注解
@Component
public class DefaultServiceImpl implements DefaultApiService {

	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public String defaultMethod(String str) {
		/*
		 * Hystrix超时配置的为2s,当实现类睡眠超过2s，服务调用者将执行服务降级函数
		 */
		int nextInt = new Random().nextInt(2000);
		System.out.println("sleep " + nextInt + "ms");
		try {
			Thread.sleep(nextInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "HELLO  " + str + " from Dubbo Spring Boot";
	}

}