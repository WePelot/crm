/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.exception;

import com.pelot.enums.ResultEnum;

/**
 * 登录权限校验
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 10:15
 */
public class CrmAuthorizeException extends RuntimeException {

    private Integer code;

    public CrmAuthorizeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public CrmAuthorizeException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
