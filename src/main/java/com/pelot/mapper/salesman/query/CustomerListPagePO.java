package com.pelot.mapper.salesman.query;

import com.pelot.mapper.common.PagePO;

import lombok.Data;

/**
 * Created by hongcj
 * 2017/9/23 15:13.
 */
@Data
public class CustomerListPagePO extends PagePO {
    /**
     * 销售id
     */
    private String salesmanId;

    /**
     * 身份
     */
    private Integer identity;

    /**
     * 模糊搜索时的客户姓名
     */
    private String name;
}
