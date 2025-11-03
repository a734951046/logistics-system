package com.logistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.DriverEntity;
import com.logistics.mapper.DriverMapper;
import com.logistics.service.DriverService;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, DriverEntity> implements DriverService {
}