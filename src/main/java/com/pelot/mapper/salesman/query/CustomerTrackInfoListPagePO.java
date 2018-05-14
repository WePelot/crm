package com.pelot.mapper.salesman.query;

import com.pelot.mapper.common.PagePO;

import lombok.Data;

/**
 * 客户追踪信息查询类
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-29 14:31
 */
@Data
public class CustomerTrackInfoListPagePO extends PagePO {

    /**
     * 客户信息ID
     */
    private String customerInfoId;
}
