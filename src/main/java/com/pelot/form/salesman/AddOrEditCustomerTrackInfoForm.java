/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.form.salesman;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * 客户最终信息添加
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-29 14:35
 */
@Data
public class AddOrEditCustomerTrackInfoForm {

    /**
     * 客户追踪信息id
     */
    private String customerTrackInfoId;

    /**
     * 客户信息ID
     */
    @NotEmpty(message = "客户信息id不能为空")
    private String customerInfoId;

    /**
     * 具体事项
     */
    @NotEmpty(message = "具体事项不能为空")
    private String desc;
}
