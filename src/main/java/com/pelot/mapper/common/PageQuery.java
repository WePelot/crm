package com.pelot.mapper.common;

import lombok.Data;

import java.util.List;

/**
 * 页码分页查询结果
 *
 * @param <T>
 * @author hongcj
 * @created 2017年9月20日 17:06:08
 */
@Data
public class PageQuery<T> {

    /**
     * 响应数据
     */
    private List<T> data;

    /**
     * 当前页码，第一页，pageNo=1
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总数量
     */
    private int totalCount;

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage(){
        if (getTotalCount() % getPageSize() == 0) {
            return getTotalCount() / getPageSize();
        } else {
            return getTotalCount() / getPageSize() + 1;
        }
    }


}
