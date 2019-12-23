package com.mscloudmesh.consumer.web;

import com.mscloudmesh.provider.service.RpcShopService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @Date 2019/12/23
 * @Version 1.0
 **/

@RestController
public class ShopController {


    @Reference
    RpcShopService shopService;

    @RequestMapping(name = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){
        return shopService.sayHello("Hello Dubbo Nacos!更多原创分享，技术交流，关注：Java技术干货（ID:raysonfang）");
    }

}
