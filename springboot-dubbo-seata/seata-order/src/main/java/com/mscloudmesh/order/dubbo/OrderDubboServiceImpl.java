package com.mscloudmesh.order.dubbo;


import com.mscloudmesh.common.dto.OrderDTO;
import com.mscloudmesh.common.dubbo.OrderDubboService;
import com.mscloudmesh.order.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDubboServiceImpl implements OrderDubboService {


    @Autowired
    OrderService orderService;

    @Override
    public void createOrder(OrderDTO order) {
        orderService.createOrder(order);
    }
}
