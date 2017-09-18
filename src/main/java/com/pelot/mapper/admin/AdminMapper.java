/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.admin;

import com.pelot.mapper.admin.dataobject.AdminInfo;
import com.pelot.mapper.admin.query.AdminLoginPO;

/**
 * 管理员mapper
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 16:37
 */
//@Component
public interface AdminMapper {
    /**
     * 管理员登录
     *
     * @param po
     * @return
     */
    public AdminInfo login(AdminLoginPO po);
}