package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("drivers")
public class DriverEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String mobile;
    private String licenseNo;
    private Long supplierId;
    private Long vehicleId;
    private String status; // ACTIVE / INACTIVE
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}