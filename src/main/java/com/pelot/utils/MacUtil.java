/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取mac地址
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-10-09 17:56
 */
public class MacUtil {

    public static String getMacAddr(HttpServletRequest request) throws Exception {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null) {
            ip = "";
        }
        if ("127.0.0.1".equals(ip) || "localhost".equalsIgnoreCase(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {

            InetAddress addr;
            addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15 && ip.indexOf(",") > 0) { // "***.***.***.***".length()
            // = 15
            ip = ip.substring(0, ip.indexOf(","));
        }
        //带:的mac值
        UdpGetClientMacAddr umac = new UdpGetClientMacAddr(ip);
        String smac = umac.GetRemoteMacAddr();
        return smac.replaceAll(":", "-");
    }
}

