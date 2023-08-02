package com.opzpy123.zweb3.lock;

import cn.hutool.core.util.ObjectUtil;
import com.opzpy123.zweb3.web.model.ActUser;
import com.opzpy123.zweb3.component.redis.lock.support.ResourceLock;
import com.opzpy123.zweb3.component.redis.lock.service.ResourceLockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisLockTest {

    @Autowired
    ResourceLockService resourceLockService;
    @Test
    public void test() throws InterruptedException {
        ActUser actUser = new ActUser();
        actUser.setUserName("aaa");
        actUser.setUserPassword("****");
        ResourceLock lock1 = resourceLockService.getLock(ObjectUtil.toString(actUser));
        ResourceLock lock2 = resourceLockService.getLock(ObjectUtil.toString(actUser));
        ResourceLock lock3 = resourceLockService.getLock(ObjectUtil.toString(actUser));
        System.out.println(lock1.tryLock());
        System.out.println(lock2.tryLock());
        System.out.println(lock3.tryLock());
        System.out.println(lock3.tryLock());
        lock2.unLock();
        Thread.sleep(1000*60*2);
        System.out.println(lock2.tryLock());
        lock1.unLock();
        System.out.println(lock2.tryLock());
        lock2.unLock();
        lock1.lock();
        lock1.unLock();
    }
}
