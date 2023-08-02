package com.opzpy123.zweb3.core.service;

public interface TokenService {

    /**
     * 验证token
     *
     * @param userName 用户名
     * @param token    token
     * @return 是否通过
     */
    Boolean validateToken(String userName, String token);

    /**
     * 生成token
     *
     * @param userName 用户名
     * @param expired  过期时间 多少毫秒
     * @return token
     */
    String generateToken(String userName, long expired);
}
