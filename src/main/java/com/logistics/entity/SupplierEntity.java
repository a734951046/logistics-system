package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("suppliers")
public class SupplierEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String contactPerson;
    private String contactPhone;
    private String address;
    private String supplierType; // CARRIER / VENDOR / WAREHOUSE
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}