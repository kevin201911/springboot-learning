package com.mscloudmesh.provider.service.impl;


import com.mscloudmesh.provider.service.RpcShopService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 接口实现类
 *
 * ## @Service 这个注解是使用dubbo提供的，
 *             这个注解中有很多属性，需要单独了解去进行配置
 * @author kevin
 * @Date 2019/12/23
 * @Version 1.0
 */
@Service
public class ShopServiceImpl implements RpcShopService {

    public String sayHello(String name) {
        return name;
    }
}
