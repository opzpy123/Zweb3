package com.opzpy123.zweb3.core.conf;

import com.opzpy123.zweb3.core.service.BootableService;
import com.opzpy123.zweb3.core.utils.SpringContextUtil;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;

@Configuration
public class ZWeb3Conf implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        SpringContextUtil.init(event.getApplicationContext());
        InitBootableService(event);
    }

    @Bean
    public ThreadPoolTaskExecutor threadPool() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(100);//线程池维护线程的最少数量
        threadPoolTaskExecutor.setMaxPoolSize(1000);//线程池维护线程的最大数量
        threadPoolTaskExecutor.setKeepAliveSeconds(300);//线程池维护线程所允许的空闲时间
        threadPoolTaskExecutor.setQueueCapacity(200);//线程池所使用的缓冲队列
        return threadPoolTaskExecutor;
    }

    /**
     * 配置项目启动时执行所有BootableService的初始化方法
     *
     * @param event event
     */
    protected void InitBootableService(ApplicationReadyEvent event) {
        Map<String, BootableService> beanMap = event.getApplicationContext().getBeansOfType(BootableService.class);
        beanMap.values().forEach(BootableService::init);
    }
}
