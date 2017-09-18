/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.service.admin;

import com.pelot.mapper.admin.AdminMapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:13
 */
@Service
public class AdminUserAuthService {
    @Resource
    private AdminMapper adminMapper;

}
