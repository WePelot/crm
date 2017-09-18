/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-08-10 11:10
 */
public class JsonUtil {

    /**
     * 对象转JSON
     * 因为gosn.toJSon这里已经做了判空的处理，这里就不做判空了
     * @param object
     * @return
     */
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
