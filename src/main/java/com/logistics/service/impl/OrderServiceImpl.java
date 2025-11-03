package com.logistics.service.impl;

import com.logistics.entity.OrderEntity;
import com.logistics.mapper.OrderMapper;
import com.logistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void saveOrder(OrderEntity order) {
        orderMapper.insert(order);
    }
}