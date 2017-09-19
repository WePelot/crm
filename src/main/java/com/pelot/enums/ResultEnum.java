/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.enums;

import lombok.Getter;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-07-19 14:24
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),

    PARAM_ERROR(1, "参数错误"),

    LOGIN_FAIL(2, "登录失败, 用户名或密码不正确"),

    LOGOUT_SUCCESS(3, "登出成功"),

    NOT_LOGIN(4, "管理员未进行登录");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
