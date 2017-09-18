/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.controller.admin;

import com.pelot.mapper.admin.AdminMapper;
import com.pelot.service.admin.AdminUserAuthService;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员用户登录
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 14:45
 */
@RestController
@RequestMapping("/admin")
public class AdminUserAuthController {

    @Autowired
    private AdminUserAuthService adminUserAuthService;

    /**
     * 登录
     * @param username
     * @param pwd
     * @param response
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "pwd", required = false) String pwd,
        HttpServletResponse response,Map<String,Object> map){
        //1.判断用户名和密码是否正确
        //2.写入cookie
        //3.设置成功后跳转列表页
        return new ModelAndView();
    }
}
