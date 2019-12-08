package com.bin.zhang.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.UUID;

public class SpringCache {
    @Cacheable(value = "data",key = "#id")
    public String getData(String id) {
        return id + "==" + UUID.randomUUID();
    }

    @CacheEvict(value = "data", allEntries = true,key = "#id", beforeInvocation = true)
    public void setData(String id) {
        System.out.println("数据被重置");
    }
}
