package com.mscloudmesh.consumer.controller;


import com.mscloudmesh.service.DefaultApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @ClassName: DemoConsumerController
   调用服务提供者对外暴露的rpc接口
 * @author kevin
 * @date: 2020/1/1
 *
 */
@RestController
public class DemoConsumerController {

	/**
	 * 引入服务提供者
	 */

	@Reference
	private DefaultApiService demoService;

	@RequestMapping("/sayHello")
	@HystrixCommand(fallbackMethod = "failBackMethod")
	public String sayHello(@RequestParam String name) {
		return demoService.defaultMethod(name);
	}

	/**
	 * 服务降级
	 * @param name
	 * @return
	 */
	public String failBackMethod(String name) {
		return "service request fail";
	}

}