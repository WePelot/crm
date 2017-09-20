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

    NOT_LOGIN(4, "管理员未进行登录"),

    SALESMANINFO_ADD_CHG_FAIL(5, "新增或修改销售人员信息失败"),

    SALESMANINFO_NOT_EXIST(6, "该销售人员已不存在"),

    SALESMANINFO_DEL_FAIL(7,"删除销售人员失败");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}