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
