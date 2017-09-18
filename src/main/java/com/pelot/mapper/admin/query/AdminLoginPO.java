/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.admin.query;

import lombok.Data;

/**
 * 管理员登录po
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:04
 */
@Data
public class AdminLoginPO {
    private String username;

    private String password;
}
