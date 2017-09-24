package com.pelot.mapper.common;

/**
 * 基本的查询PO
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-20 16:41
 */
public class PagePO {

    /**
     * 当前页码，第一页，pageNo=1
     */
    private int pageNo = 1;

    /**
     * 每页条数,默认为20条
     */
    private int pageSize = 20;


    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 获取开始的查询数
     */
    public int getStart() {
        return getPageNo() * getPageSize();
    }

}
