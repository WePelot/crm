package com.pelot.mapper.salesman.query;

import com.pelot.mapper.common.PagePO;

import lombok.Data;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017/9/23 15:13.
 */
@Data
public class SalesmanListPagePO extends PagePO {
    /**
     * 身份，0为普通销售，1为销售组长，2为总负责人
     */
    private Integer identity;

    /**
     * 销售id
     */
    private String salesmanId;

    /**
     * 所属负责人
     */
    private String belong;
}
