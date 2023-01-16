package com.opzpy123.zweb3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.opzpy123.zweb3.mapper.ActUserMapper;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.service.ActUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("actUserService")
public class ActUserServiceImpl extends ServiceImpl<ActUserMapper, ActUser> implements ActUserService {
}
