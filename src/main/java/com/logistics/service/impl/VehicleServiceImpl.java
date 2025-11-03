package com.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.VehicleEntity;
import com.logistics.mapper.VehicleMapper;
import com.logistics.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl extends ServiceImpl<VehicleMapper, VehicleEntity> implements VehicleService {
}