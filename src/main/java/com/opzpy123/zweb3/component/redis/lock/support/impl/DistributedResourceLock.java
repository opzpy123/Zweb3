package com.opzpy123.zweb3.component.redis.lock.support.impl;

import com.opzpy123.zweb3.core.exception.WebException;
import com.opzpy123.zweb3.component.redis.lock.support.ResourceLock;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class DistributedResourceLock implements ResourceLock {
    private final String lockName;//锁名
    private final String lockValue;//锁内容
    private final long keepTime;//锁存活时间
    private final TimeUnit unit;//时间单位
    private final RedisTemplate<String, Object> redisTemplate;//redisTemplate
    private final long timeout = 10 * 1000L;//阻塞获取锁的超时时间 默认10秒

    public DistributedResourceLock(String lockName, String lockValue, long keepTime, TimeUnit unit, RedisTemplate<String, Object> redisTemplate) {
        this.lockName = lockName;
        this.lockValue = lockValue;
        this.keepTime = keepTime;
        this.unit = unit;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void lock() {
        long currentTimeMillis = System.currentTimeMillis();
        for (; ; ) {
            if (tryLock()) {
                return;
            }
            if (System.currentTimeMillis() - currentTimeMillis > timeout) {
                throw new WebException("获取锁超时");
            }
        }
    }

    @Override
    public boolean tryLock() {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(lockName, lockValue, keepTime, unit));
    }

    @Override
    public void unLock() {
        synchronized (this) {
            String redisLockValue = (String) redisTemplate.opsForValue().get(lockName);
            if (lockValue.equals(redisLockValue)) {
                redisTemplate.delete(lockName);
            }
        }
    }

    @Override
    public String getLockName() {
        return lockName;
    }

    @Override
    public long getKeepTime() {
        return keepTime;
    }
}
