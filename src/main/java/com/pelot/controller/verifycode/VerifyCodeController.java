/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.controller.verifycode;

import com.pelot.VO.ResultVO;
import com.pelot.utils.ResultVOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码控制类
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-10-19 16:32
 */
@RestController
@RequestMapping("/verifyCode")
public class VerifyCodeController {

    @PostMapping("/checkVerifyCode")
    public ResultVO checkVerifyCode(HttpServletRequest request, @RequestParam String verCode) {
        //存入会话session
        HttpSession session = request.getSession(true);
        //获取之前的session
        String verCodeInSession = (String) session.getAttribute("verCode");
        if (verCodeInSession.equals(verCode.toLowerCase())) {
            //验证码一致
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(-1, "验证码输入不正确");
        }
    }
}
