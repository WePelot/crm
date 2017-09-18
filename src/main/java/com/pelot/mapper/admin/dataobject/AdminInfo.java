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
 * 管理员信息
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 16:59
 */
@Data
public class AdminInfo {
    private String id;
    private String username;
    private String password;
}
