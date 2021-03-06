package com.linjun.utils;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(value = {"com.linjun"})
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(RRException.class)
    public JsonResult handleRRException(RRException e) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.put("code", e.getCode());
        jsonResult.put("msg", e.getMessage());

        return jsonResult;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public JsonResult handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return JsonResult.error("数据库中已存在该记录");
    }

    @ExceptionHandler(AuthorizationException.class)
    public JsonResult handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage(), e);
        return JsonResult.error("没有权限，请联系管理员授权");
    }

    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return JsonResult.error();
    }


    @ExceptionHandler(ApiRRException.class)
    public Object handleApiRRException(ApiRRException e) {
        HashMap result = new HashMap();
        result.put("errno", e.getErrno());
        result.put("errmsg", e.getErrmsg());
        return result;
    }
}
