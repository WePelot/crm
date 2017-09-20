package com.pelot.mapper.common;

import lombok.Data;

/**
 * 基本的查询PO
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-20 16:41
 */
@Data
public class PagePO {

    /**
     * 当前页码，第一页，pageNo=1
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 获取开始的查询数
     */
    public int getStart() {
        return getPageNo() * getPageSize();
    }

}
