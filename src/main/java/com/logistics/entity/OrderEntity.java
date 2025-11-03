package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orders")
public class OrderEntity {
    private Long id;
    private String description;
    private Integer quantity;
}