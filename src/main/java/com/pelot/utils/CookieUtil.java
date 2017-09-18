/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-08-21 15:07
 */
public class CookieUtil {
    /**
     * 设置cookie
     * @param response
     * @param key
     * @param value
     * @param expire 过期时间
     */
    public static void set(HttpServletResponse response,String key,String value,Integer expire){
        Cookie cookie = new Cookie(key,value);
        cookie.setPath("/");
        cookie.setMaxAge(expire);
        response.addCookie(cookie);
    }

    public static Cookie get(HttpServletRequest request, String key){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(key)) {
            return cookieMap.get(key);
        }else {
            return null;
        }
    }

    /**
     * 将cookie封装成Map
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
