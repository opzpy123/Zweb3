package com.opzpy123.zweb3.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCache<T> {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final static String CACHE_PREFIX = "CACHE:";//redis缓存key前缀

    public T get(String key) {
        return (T) redisTemplate.opsForValue().get(CACHE_PREFIX + key);
    }

    public void put(String key, T value) {
        redisTemplate.opsForValue().set(CACHE_PREFIX + key, value);
    }

    public void putWithExpire(String key, T value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(CACHE_PREFIX + key, value, timeout, unit);
    }

    public void delete(String key) {
        redisTemplate.delete(CACHE_PREFIX + key);
    }
}
