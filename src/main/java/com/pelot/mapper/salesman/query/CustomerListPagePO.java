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
}
