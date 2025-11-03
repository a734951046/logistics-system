package com.logistics.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.logistics.entity.VehicleEntity;
import com.logistics.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public VehicleEntity create(@RequestBody VehicleEntity v) {
        vehicleService.save(v);
        return v;
    }

    @GetMapping("/{id}")
    public VehicleEntity get(@PathVariable Long id) {
        return vehicleService.getById(id);
    }

    @PutMapping("/{id}")
    public VehicleEntity update(@PathVariable Long id, @RequestBody VehicleEntity v) {
        v.setId(id);
        vehicleService.updateById(v);
        return vehicleService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vehicleService.removeById(id);
    }

    @GetMapping
    public Page<VehicleEntity> list(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int size) {
        return vehicleService.page(new Page<>(page, size));
    }
}