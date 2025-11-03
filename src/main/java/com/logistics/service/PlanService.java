package com.logistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.logistics.entity.PlanEntity;

public interface PlanService extends IService<PlanEntity> {
    /**
     * Assign a supplier to a plan (business logic may notify supplier, create tasks, etc.)
     */
    boolean assignSupplier(Long planId, Long supplierId);

    /**
     * Assign a driver and vehicle to a plan
     */
    boolean assignDriverAndVehicle(Long planId, Long driverId, Long vehicleId);
}
