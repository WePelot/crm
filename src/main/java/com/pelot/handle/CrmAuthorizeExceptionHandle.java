/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.handle;

import com.pelot.exception.CrmAuthorizeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 10:20
 */
public class CrmAuthorizeExceptionHandle {

    //处理权限异常
    @ExceptionHandler(value = CrmAuthorizeException.class)
    public ModelAndView handleException() {
        return new ModelAndView("/html/admin/login.html");
    }
}
