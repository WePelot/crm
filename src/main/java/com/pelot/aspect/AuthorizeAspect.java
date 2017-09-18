/*
 * 
 * . 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
    @Pointcut("execution(public * com.pelot.controller.admin.*.*(..))"
        + "&&!execution(public * com.pelot.controller.admin.AdminUserAutoController.*(..))")
    public void verify(){}

    @Before(value = "verify()")
    public void doVerify(){

    }
}
