package com.mscloudmesh.order.service;


import com.mscloudmesh.common.dto.OrderDTO;

public interface OrderService {

    void createOrder(OrderDTO order);
}
