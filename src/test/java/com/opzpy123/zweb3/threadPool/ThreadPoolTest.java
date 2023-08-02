package com.opzpy123.zweb3.threadPool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootTest
public class ThreadPoolTest {
    @Autowired
    @Qualifier("threadPool")
    ThreadPoolTaskExecutor threadPool;

    @Test
    public void test(){
        threadPool.execute(()->{
            System.out.println(Thread.currentThread());
        });
        threadPool.execute(()->{
            System.out.println(Thread.currentThread());
        });
    }
}
