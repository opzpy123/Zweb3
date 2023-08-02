package com.opzpy123.zweb3.core.interceptor;

import cn.hutool.core.util.StrUtil;
import com.opzpy123.zweb3.core.exception.WebException;
import com.opzpy123.zweb3.web.dto.ContextUserInfo;
import com.opzpy123.zweb3.web.model.ActUser;
import com.opzpy123.zweb3.web.service.ActUserService;
import com.opzpy123.zweb3.core.service.TokenService;
import com.opzpy123.zweb3.core.utils.AppContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.opzpy123.zweb3.core.constant.WebInfoConst.HTTP_HEADER_USERNAME;
import static com.opzpy123.zweb3.core.constant.WebInfoConst.HTTP_HEADER_USERTOKEN;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    ActUserService actUserService;
    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = request.getHeader(HTTP_HEADER_USERNAME);
        String userToken = request.getHeader(HTTP_HEADER_USERTOKEN);
        if (StrUtil.isBlank(userName)) {
            throw new WebException("身份验证失败：用户名不能为空");
        }
        if (StrUtil.isBlank(userToken)) {
            throw new WebException("身份验证失败：用户token不能为空");
        }
        if (StrUtil.isNotBlank(userName) && StrUtil.isNotBlank(userToken)) {
            Boolean isValid = tokenService.validateToken(userName, userToken);
            if (isValid) {
                ActUser actUser = actUserService.findByUsername(userName);
                if (actUser != null) {
                    ContextUserInfo contextUserInfo = new ContextUserInfo();
                    AppContext.setUserInfo(contextUserInfo);
                    BeanUtils.copyProperties(actUser, contextUserInfo);
                    return true;
                } else {
                    throw new WebException("身份验证失败：用户不存在");
                }
            }
        }
        throw new WebException("身份验证失败：系统错误");
    }
}
