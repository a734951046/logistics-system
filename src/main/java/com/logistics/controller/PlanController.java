package com.logistics.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.logistics.entity.PlanEntity;
import com.logistics.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping
    public PlanEntity create(@RequestBody PlanEntity plan) {
        plan.setStatus(plan.getStatus() == null ? "PENDING" : plan.getStatus());
        planService.save(plan);
        return plan;
    }

    @GetMapping("/{id}")
    public PlanEntity get(@PathVariable Long id) {
        return planService.getById(id);
    }

    @PutMapping("/{id}")
    public PlanEntity update(@PathVariable Long id, @RequestBody PlanEntity plan) {
        plan.setId(id);
        planService.updateById(plan);
        return planService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planService.removeById(id);
    }

    @GetMapping
    public Page<PlanEntity> list(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(required = false) String status) {
        Page<PlanEntity> p = new Page<>(page, size);
        if (status == null) return planService.page(p);
        // simple filter
        return planService.page(p, new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<PlanEntity>().eq("status", status));
    }

    @PostMapping("/{id}/assign-supplier")
    public String assignSupplier(@PathVariable Long id, @RequestParam Long supplierId) {
        boolean ok = planService.assignSupplier(id, supplierId);
        return ok ? "OK" : "FAILED";
    }

    @PostMapping("/{id}/assign-driver")
    public String assignDriver(@PathVariable Long id, @RequestParam Long driverId, @RequestParam Long vehicleId) {
        boolean ok = planService.assignDriverAndVehicle(id, driverId, vehicleId);
        return ok ? "OK" : "FAILED";
    }
}
