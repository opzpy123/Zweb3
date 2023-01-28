package com.opzpy123.zweb3.cache;

import cn.hutool.core.util.IdUtil;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.redis.cache.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisCacheTest {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    RedisCache<ActUser> redisCache;

    @Test
    public void redisTemplateTest(){
        ActUser actUser = new ActUser();
        actUser.setId(IdUtil.fastSimpleUUID());
        actUser.setUserName("actUser_001");
        actUser.setUserPassword("********");
        redisCache.put(actUser.getId(),actUser);
        ActUser result = redisCache.get(actUser.getId());
        System.out.println(result);
    }
}
