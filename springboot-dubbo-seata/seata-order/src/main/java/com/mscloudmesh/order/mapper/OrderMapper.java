package com.mscloudmesh.order.mapper;


import com.mscloudmesh.order.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    void createOrder(Order order);
}
