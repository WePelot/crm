package com.pelot.handle;

import com.pelot.exception.CrmAuthorizeException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 10:20
 */
@ControllerAdvice
public class CrmAuthorizeExceptionHandle {

    //处理权限异常
    @ExceptionHandler(value = CrmAuthorizeException.class)
    public ModelAndView handleException() {
        return new ModelAndView("/html/salesman/login.html");
    }
}
