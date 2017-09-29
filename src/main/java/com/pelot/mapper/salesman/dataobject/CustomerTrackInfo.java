package com.pelot.mapper.salesman.dataobject;

import lombok.Data;

/**
 * 客户信息跟踪
 * Created by hongcj
 * 2017/9/27 0:15.
 */
@Data
public class CustomerTrackInfo {

    private String id;

    /**
     * 客户信息ID
     */
    private String customerInfoId;

    /**
     * 客户姓名
     */
    private String customerInfoName;

    /**
     * 具体事项
     */
    private String desc;

    /**
     * 创建时间
     */
    private String createTime;
}
