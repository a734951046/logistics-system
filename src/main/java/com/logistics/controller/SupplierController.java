package com.logistics.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.logistics.entity.SupplierEntity;
import com.logistics.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public SupplierEntity create(@RequestBody SupplierEntity s) {
        supplierService.save(s);
        return s;
    }

    @GetMapping("/{id}")
    public SupplierEntity get(@PathVariable Long id) {
        return supplierService.getById(id);
    }

    @PutMapping("/{id}")
    public SupplierEntity update(@PathVariable Long id, @RequestBody SupplierEntity s) {
        s.setId(id);
        supplierService.updateById(s);
        return supplierService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        supplierService.removeById(id);
    }

    @GetMapping
    public Page<SupplierEntity> list(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return supplierService.page(new Page<>(page, size));
    }
}