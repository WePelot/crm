/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.service.salesman;

import com.pelot.form.admin.SalesmanInfoForm;
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

    public SalesmanInfo add(SalesmanInfoForm info) {
        return salesmanManage.add(info);
    }

    public SalesmanInfo chg(SalesmanInfoForm info) {
        return salesmanManage.chg(info);
    }

    public SalesmanInfo getSalesmanById(String id) {
        return salesmanManage.getSalesmanById(id);
    }

    public void delSalesmanById(String id) {
        salesmanManage.delSalesmanById(id);
    }
}
