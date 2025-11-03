package com.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.PlanEntity;
import com.logistics.mapper.PlanMapper;
import com.logistics.service.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.logistics.service.DriverService;
import com.logistics.service.VehicleService;
import com.logistics.service.SupplierService;

@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, PlanEntity> implements PlanService {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehicleService vehicleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean assignSupplier(Long planId, Long supplierId) {
        // basic validation
        if (planId == null || supplierId == null) return false;
        if (supplierService.getById(supplierId) == null) return false;
        PlanEntity plan = this.getById(planId);
        if (plan == null) return false;
        plan.setAssignedSupplierId(supplierId);
        plan.setStatus("ASSIGNED");
        return this.updateById(plan);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean assignDriverAndVehicle(Long planId, Long driverId, Long vehicleId) {
        if (planId == null || driverId == null || vehicleId == null) return false;
        if (driverService.getById(driverId) == null) return false;
        if (vehicleService.getById(vehicleId) == null) return false;
        PlanEntity plan = this.getById(planId);
        if (plan == null) return false;
        // store assignment using the containerList or a dedicated field in future; for now set status
        plan.setStatus("DRIVER_ASSIGNED");
        // for auditability, we leave driver/vehicle relation to driver/vehicle tables; could add plan_driver table later
        return this.updateById(plan);
    }
}
