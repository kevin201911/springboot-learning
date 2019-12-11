package com.mscloudmesh.springbootredislimit.controller;


import com.mscloudmesh.springbootredislimit.enums.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class LimiterController {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    @Limit(key = "test", period = 10, count = 10, name="resource", prefix = "limit")
    @GetMapping("/test")
    public int testLimiter() {
        // 意味着10S内最多可以访问10次
        return ATOMIC_INTEGER.incrementAndGet();
    }
}