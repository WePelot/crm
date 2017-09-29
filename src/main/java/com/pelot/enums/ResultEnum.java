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

    SALESMANINFO_ADD_FAIL(5, "新增销售人员信息失败"),

    SALESMANINFO_CHG_FAIL(6, "修改销售人员信息失败"),

    SALESMANINFO_NOT_EXIST(7, "该销售人员已不存在"),

    SALESMANINFO_DEL_FAIL(8, "删除销售人员失败"),

    SALESMANINFO_RESETPWD_FAIL(9, "销售人员密码重置失败"),

    SALESMANINFO_CHGPWD_FAIL(10, "修改密码失败"),

    CUSTOMERINFO_NOT_EXIST(11, "该客户信息不存在"),

    CUSTOMERINFO_DEL_FAIL(12, "删除客户信息失败"),

    CUSTOMERINFO_ADD_FAIL(13, "新增客户信息失败"),

    CUSTOMERINFO_CHG_FAIL(14, "修改客户信息失败"),

    CUSTOMER_TRACK_INFO_NOT_EXIST(15, "该客户追踪信息不存在"),

    CUSTOMER_TRACK_INFO_DEL_FAIL(16, "删除客户追踪信息失败"),

    CUSTOMER_TRACK_INFO_ADD_FAIL(17, "新增客户追踪信息失败"),

    CUSTOMER_TRACK_INFO_CHG_FAIL(18, "修改客户追踪信息失败"),;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
