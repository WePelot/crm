/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.admin.dataobject;

import lombok.Data;

/**
 * 销售人员信息
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 19:00
 */
@Data
public class SalesManInfo {

    private String id;

    private String username;

    private String password;

    /**
     * 是否为销售组长，1为是，0为否，默认为否
     */
    private Integer flag = new Integer(0);
}
