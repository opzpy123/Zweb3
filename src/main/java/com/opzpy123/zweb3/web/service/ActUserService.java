package com.opzpy123.zweb3.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.opzpy123.zweb3.web.model.ActUser;

public interface ActUserService extends IService<ActUser> {

    /**
     * 根据用户名获取用用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    ActUser findByUsername(String username);
}
