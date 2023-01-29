package com.opzpy123.zweb3.redis.lock.service.impl;

import cn.hutool.core.util.IdUtil;
import com.opzpy123.zweb3.redis.lock.support.ResourceLock;
import com.opzpy123.zweb3.redis.lock.service.ResourceLockService;
import com.opzpy123.zweb3.redis.lock.support.impl.DistributedResourceLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service("resourceLockService")
public class ResourceLockServiceImpl implements ResourceLockService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private final static String LOCK_PREFIX = "LOCK:";//redis锁key前缀
    private final static Long EXPIRE_TIME = 60 * 1000L;//默认1分钟过期
    private final static TimeUnit TIME_UNIT = TimeUnit.MILLISECONDS;

    @Override
    public ResourceLock getLock(String lockName) {
        DistributedResourceLock distributedResourceLock = new DistributedResourceLock(LOCK_PREFIX + lockName, IdUtil.fastSimpleUUID(), EXPIRE_TIME, TIME_UNIT, redisTemplate);
        return distributedResourceLock;
    }

    @Override
    public ResourceLock getLock(String lockName, long expireTime, TimeUnit timeUnit) {
        DistributedResourceLock distributedResourceLock = new DistributedResourceLock(LOCK_PREFIX + lockName, IdUtil.fastSimpleUUID(), expireTime, timeUnit, redisTemplate);
        return distributedResourceLock;
    }
}
