package com.opzpy123.zweb3.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache<T> {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void set(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }
}
