package com.pelot.mapper.common;

import java.util.List;
import java.util.function.Function;

/**
 * 页码分析执行过程
 *
 * @author hongcj
 * @created 2017年9月20日 17:06:08
 */
public class PageResolve {
    /**
     * 页码分页实现
     *
     * @param r 分页入参
     * @param c 分页数量函数
     * @param l 分页列表函数
     * @return
     */
    public static <T, R extends PagePO> PageQuery<T> page(R r, Function<R, Integer> c, Function<R, List<T>> l) {
        PageQuery<T> query = new PageQuery<>();
        query.setPageNo(r.getPageNo());
        query.setPageSize(r.getPageSize());
        r.setPageNo(r.getPageNo() - 1); // 上层第一页默认是1，所以需要-1
        Integer count = c.apply(r);
        query.setTotalCount(count);
        if (count > 0) {
            query.setData(l.apply(r));
        }
        return query;
    }

}
