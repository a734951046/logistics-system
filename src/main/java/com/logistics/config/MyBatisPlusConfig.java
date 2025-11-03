package com.logistics.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.logistics.mapper")
public class MyBatisPlusConfig {
}