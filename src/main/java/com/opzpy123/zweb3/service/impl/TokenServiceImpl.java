package com.opzpy123.zweb3.service.impl;

import cn.hutool.core.util.IdUtil;
import com.opzpy123.zweb3.dto.TokenInfoDto;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.component.redis.cache.RedisCache;
import com.opzpy123.zweb3.service.ActUserService;
import com.opzpy123.zweb3.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Autowired
    ActUserService actUserService;
    @Autowired
    RedisCache<TokenInfoDto> redisCache;

    public Boolean validateToken(String userName, String token) {
        TokenInfoDto tokenInfoDto = redisCache.get(token);
        if (tokenInfoDto == null) {
            log.error("token不存在");
            return false;
        }
        if (tokenInfoDto.getExpiredDate().getTime() < new Date().getTime()) {
            log.error("token已过期");
            redisCache.delete(token);
            return false;
        }
        if (!tokenInfoDto.getUserName().equals(userName)) {
            log.error("token无效");
            return false;
        }
        return true;
    }

    public String generateToken(String userName, long expired) {
        //允许多用户登录同一个号
        ActUser actUser = actUserService.findByUsername(userName);
        String token = IdUtil.randomUUID();

        TokenInfoDto tokenInfoDto = new TokenInfoDto();
        tokenInfoDto.setUserId(actUser.getId());
        tokenInfoDto.setUserName(actUser.getUserName());
        tokenInfoDto.setToken(token);
        tokenInfoDto.setExpiredDate(new Date(new Date().getTime() + expired));

        redisCache.put(token, tokenInfoDto);
        log.info("token已生成{},信息：{}", token, tokenInfoDto);
        return token;
    }
}
