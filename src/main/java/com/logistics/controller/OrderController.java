package com.logistics.controller;

import com.logistics.entity.OrderEntity;
import com.logistics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderEntity order) {
        orderService.saveOrder(order);
    }
}