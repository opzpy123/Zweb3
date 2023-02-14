package com.opzpy123.zweb3.component.redis.lock.service;

import com.opzpy123.zweb3.component.redis.lock.support.ResourceLock;

import java.util.concurrent.TimeUnit;

public interface ResourceLockService {
    /**
     * 取得资源锁，默认配置：过期时间为1分钟。
     *
     * @param lockName 锁名称
     * @return 资源锁对象
     */
    ResourceLock getLock(String lockName);

    /**
     * 取得资源锁
     *
     * @param lockName   锁名称
     * @param expireTime 资源锁保持时间
     * @param timeUnit   时间单位
     * @return 资源锁对象
     */
    ResourceLock getLock(String lockName, long expireTime, TimeUnit timeUnit);
}
