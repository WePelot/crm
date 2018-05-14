package com.pelot.aspect;

import com.pelot.constant.CookieConstant;
import com.pelot.enums.ResultEnum;
import com.pelot.exception.CrmAuthorizeException;
import com.pelot.utils.CookieUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录权限验证
 * @author hongcj
 * @version V1.0
 * @since 2017-08-21 15:34
 */
@Aspect
@Component
@Slf4j
public class AuthorizeAspect {


    // 定义切面,拦截出用户登录外的请求
    @Pointcut("execution(public * com.pelot.controller.salesman.*.*(..))"
        + "&&!execution(public * com.pelot.controller.salesman.SalesmanLoginController.*(..))")
    public void verify(){}

    @Before(value = "verify()")
    public void doVerify(){
        //获取cookie
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new CrmAuthorizeException(ResultEnum.NOT_LOGIN);
        }
    }
}
