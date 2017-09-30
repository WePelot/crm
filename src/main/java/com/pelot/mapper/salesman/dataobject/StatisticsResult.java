/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.salesman.dataobject;

import lombok.Data;

/**
 * 统计结果
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-29 16:35
 */
@Data
public class StatisticsResult {
    /**
     * 组长ID
     */
    private String salesmanLeaderId;

    /**
     * 组长名称
     */
    public String salesmanLeaderName;

    /**
     * 组内销售人数
     */
    private Integer salesmanCount;

    /**
     * 组内客户数量
     */
    private Integer customerCount;

}
