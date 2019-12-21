package com.mscloudmesh.common.dubbo;


import com.mscloudmesh.common.dto.OrderDTO;

public interface OrderDubboService {

    void createOrder(OrderDTO order);
}
