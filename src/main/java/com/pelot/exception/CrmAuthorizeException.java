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
