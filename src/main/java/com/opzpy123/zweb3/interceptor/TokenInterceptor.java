package com.opzpy123.zweb3.interceptor;

import cn.hutool.core.util.StrUtil;
import com.opzpy123.zweb3.dto.ContextUserInfo;
import com.opzpy123.zweb3.model.ActUser;
import com.opzpy123.zweb3.service.ActUserService;
import com.opzpy123.zweb3.service.TokenService;
import com.opzpy123.zweb3.utils.AppContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.opzpy123.zweb3.constant.WebInfoConst.HTTP_HEADER_USERNAME;
import static com.opzpy123.zweb3.constant.WebInfoConst.HTTP_HEADER_USERTOKEN;

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
            log.error("用户名不能为空");
            return false;
        }
        if (StrUtil.isBlank(userToken)) {
            log.error("用户token不能为空");
            return false;
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
                    log.error("用户不存在");
                    return false;
                }
            }
        }
        return false;
    }
}
