package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("plans")
public class PlanEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String planNo;
    private Long orderId;
    private Long assignedSupplierId;
    private Long routeId;
    private Long contractId;
    private String status; // e.g. PENDING, ASSIGNED, IN_TRANSIT, COMPLETED
    private LocalDateTime plannedDate;
    private String containerList; // JSON array of container numbers
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}