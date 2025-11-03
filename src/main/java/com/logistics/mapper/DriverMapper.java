package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.entity.DriverEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DriverMapper extends BaseMapper<DriverEntity> {
}