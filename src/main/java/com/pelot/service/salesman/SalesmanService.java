/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.service.salesman;

import com.pelot.manage.SalesmanManage;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 销售人员登录
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:13
 */
@Service
public class SalesmanService {
    @Resource
    private SalesmanManage salesmanManage;

    public PageQuery<SalesmanInfo> list(SalesmanListPagePO po) {
        return salesmanManage.list(po);
    }

    public void add(SalesmanInfo info) {
        salesmanManage.add(info);
    }

    public void chg(SalesmanInfo info) {
        salesmanManage.chg(info);
    }

    public SalesmanInfo getSalesmanInfoById(String id) {
        return salesmanManage.getSalesmanInfoById(id);
    }

    public void delSalesmanById(String id) {
        salesmanManage.delSalesmanById(id);
    }

    public void resetPwd(String id) {
        salesmanManage.resetPwd(id);
    }

    public void chgPwd(String newPwd, String id) {
        salesmanManage.chgPwd(newPwd, id);
    }
}
