/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.admin;

import com.pelot.form.admin.SalesmanInfoForm;
import com.pelot.mapper.admin.dataobject.AdminInfo;
import com.pelot.mapper.admin.dataobject.SalesmanInfo;
import com.pelot.mapper.admin.query.AdminLoginPO;
import com.pelot.mapper.common.PagePO;

import java.util.List;

/**
 * 管理员mapper
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 16:37
 */
public interface AdminMapper {
    /**
     * 管理员登录
     *
     * @param po
     * @return
     */
    AdminInfo login(AdminLoginPO po);

    /**
     * 销售人员列表
     *
     * @return
     */
    List<SalesmanInfo> salesmanInfolist(PagePO po);

    /**
     * 增加销售人员
     *
     * @param infoForm
     * @return
     */
    SalesmanInfo addSalesmanInfo(SalesmanInfoForm infoForm);

    /**
     * 修改销售人员信息
     *
     * @param infoForm
     * @return
     */
    SalesmanInfo chgSalesmanInfo(SalesmanInfoForm infoForm);

    /**
     * 根据id获取销售人员信息
     *
     * @param id
     * @return
     */
    SalesmanInfo getSalesmanInfoById(String id);

    /**
     * 分页查询销售人员的数目
     *
     * @param po
     * @return
     */
    Integer salesmanInfolistCount(PagePO po);
}
