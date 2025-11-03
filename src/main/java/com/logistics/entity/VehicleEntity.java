package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("vehicles")
public class VehicleEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String plateNo;
    private String type; // TRUCK / TRAILER
    private String capacity;
    private Long supplierId;
    private String status; // ACTIVE / INACTIVE
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}