/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.utils;

import com.pelot.enums.CodeEnum;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-08-17 18:13
 */
public class EnumUtil {
    /**
     * 根据code获取枚举
     */
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> t){
        if(code == null){
            return null;
        }
        for (T each :t.getEnumConstants()) {
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
