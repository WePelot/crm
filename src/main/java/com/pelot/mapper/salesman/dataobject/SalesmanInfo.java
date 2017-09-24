/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.salesman.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pelot.enums.SalesmanInfoIdentityEnum;
import com.pelot.utils.EnumUtil;
import lombok.Data;

/**
 * 销售人员信息
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 19:00
 */
@Data
public class SalesmanInfo {

    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系号码
     */
    private String phone;

    /**
     * 身份，0为普通销售，1为销售组长，2为总负责人
     */
    private Integer identity = new Integer(0);

    /**
     * 所属上级，总负责人上级为0
     */
    private String belong;

    /**
     * 是否被删除，0为未删除，1为已删除
     */
    private Integer deleted;

    /**
     * 获取销售身份
     *
     * @return
     */
    @JsonIgnore
    public SalesmanInfoIdentityEnum getSalesmanInfoIdentityEnum() {
        return EnumUtil.getByCode(identity, SalesmanInfoIdentityEnum.class);
    }
}
