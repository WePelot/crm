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

    LOGIN_SUCCESS(3, "登录成功"),

    LOGOUT_SUCCESS(4, "登出成功"),

    NOT_LOGIN(5, "管理员未进行登录"),

    SALESMANINFO_ADD_FAIL(6, "新增销售人员信息失败"),

    SALESMANINFO_CHG_FAIL(7, "修改销售人员信息失败"),

    SALESMANINFO_NOT_EXIST(8, "该销售人员已不存在"),

    SALESMANINFO_DEL_FAIL(9, "删除销售人员失败"),

    SALESMANINFO_RESETPWD_FAIL(10, "销售人员密码重置失败"),

    SALESMANINFO_CHGPWD_FAIL(11, "修改密码失败"),

    CUSTOMERINFO_NOT_EXIST(12, "该客户信息不存在"),

    CUSTOMERINFO_DEL_FAIL(13, "删除客户信息失败"),

    CUSTOMERINFO_ADD_FAIL(14, "新增客户信息失败"),

    CUSTOMERINFO_CHG_FAIL(15, "修改客户信息失败"),

    CUSTOMER_TRACK_INFO_NOT_EXIST(16, "该客户追踪信息不存在"),

    CUSTOMER_TRACK_INFO_DEL_FAIL(17, "删除客户追踪信息失败"),

    CUSTOMER_TRACK_INFO_ADD_FAIL(18, "新增客户追踪信息失败"),

    CUSTOMER_TRACK_INFO_CHG_FAIL(19, "修改客户追踪信息失败"),

    STATISTICS_FAIL(20, "获取统计信息失败"),

    GET_MACADDR_FAIL(21, "获取客户端mac地址失败");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
