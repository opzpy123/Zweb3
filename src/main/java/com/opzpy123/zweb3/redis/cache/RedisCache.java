package com.opzpy123.zweb3.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCache<T> {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void put(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void putWithExpire(String key, T value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
