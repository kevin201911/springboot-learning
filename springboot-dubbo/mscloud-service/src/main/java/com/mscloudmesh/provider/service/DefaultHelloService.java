package com.mscloudmesh.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.mscloudmesh.stub.HelloService;

@Service(
        version = "${hello.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + " !";
    }
}
