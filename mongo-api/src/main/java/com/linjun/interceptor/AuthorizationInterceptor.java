package com.linjun.interceptor;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.TokenVo;
import com.linjun.service.TokenService;
import com.linjun.utils.ApiRRException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenService tokenService;

    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";
    public static final String LOGIN_TOKEN_KEY = "X-Nideshop-Token";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IgnoreAuth annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证token
        if (annotation != null) {
            return true;
        }

        //从header中获取token
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(LOGIN_TOKEN_KEY);
        }

        //token为空
        if (StringUtils.isBlank(token)) {
            throw new ApiRRException("请先登录", 401);
        }

        //查询token信息
        TokenVo tokenVo = tokenService.queryByToken(token);
        if (tokenVo == null || tokenVo.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new ApiRRException("token失效，请重新登录", 401);
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(LOGIN_USER_KEY, tokenVo.getUserId());

        return true;
    }
}
