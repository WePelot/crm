/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import java.util.Random;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-07-19 14:32
 */
public class KeyUtil {

    //防止多线程时出现相同的数字
    public synchronized static  String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
