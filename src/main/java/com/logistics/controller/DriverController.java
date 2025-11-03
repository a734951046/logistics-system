package com.logistics.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.logistics.entity.DriverEntity;
import com.logistics.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public DriverEntity create(@RequestBody DriverEntity d) {
        driverService.save(d);
        return d;
    }

    @GetMapping("/{id}")
    public DriverEntity get(@PathVariable Long id) {
        return driverService.getById(id);
    }

    @PutMapping("/{id}")
    public DriverEntity update(@PathVariable Long id, @RequestBody DriverEntity d) {
        d.setId(id);
        driverService.updateById(d);
        return driverService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        driverService.removeById(id);
    }

    @GetMapping
    public Page<DriverEntity> list(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        return driverService.page(new Page<>(page, size));
    }
}