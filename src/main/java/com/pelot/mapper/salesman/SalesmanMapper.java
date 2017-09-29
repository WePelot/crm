/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.mapper.salesman;

import com.pelot.form.salesman.CustomerInfoForm;
import com.pelot.mapper.common.PagePO;
import com.pelot.mapper.salesman.dataobject.CustomerInfo;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.*;

import java.util.List;

/**
 * 管理员mapper
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 16:37
 */
public interface SalesmanMapper {
    /**
     * 管理员登录
     *
     * @param po
     * @return
     */
    SalesmanInfo login(SalesmanLoginPO po);

    /**
     * 销售人员列表
     *
     * @return
     */
    List<SalesmanInfo> salesmanInfolist(PagePO po);

    /**
     * 分页查询销售人员的数目
     *
     * @param po
     * @return
     */
    Integer salesmanInfolistCount(SalesmanListPagePO po);

    /**
     * 增加销售人员
     *
     * @param infoForm
     * @return
     */
    void addSalesmanInfo(SalesmanInfo infoForm);

    /**
     * 修改销售人员信息
     *
     * @param infoForm
     * @return
     */
    void chgSalesmanInfo(SalesmanInfo infoForm);

    /**
     * 根据id获取销售人员信息
     *
     * @param salesmanId
     * @return
     */
    SalesmanInfo getSalesmanInfoById(String salesmanId);

    /**
     * 根据id删除人员
     * @param salesmanId
     * @return
     */
    void delSalesmanById(String salesmanId);

    /**
     * 密码重置
     *
     * @param salesmanId
     */
    void resetPwd(String salesmanId);

    /**
     * 修改密码
     *
     * @param dto
     */
    void chgPwd(ChgPwdDTO dto);

    /**
     * 根据手机号码查询销售人员
     *
     * @param phone
     * @return
     */
    SalesmanInfo getSalesmanInfoByPhone(String phone);

    /**
     * 根据用户名查询销售人员
     *
     * @param username
     * @return
     */
    SalesmanInfo getSalesmanInfoByUsername(String username);

    /**
     * 根据用户名，姓名，手机号码查询销售人员
     *
     * @param po
     * @return
     */
    SalesmanInfo getSalesmanInfoByQuery(SalesmanInfoQueryPO po);

    /**
     * 获取所有的销售人员信息
     *
     * @return
     */
    List<SalesmanInfo> findAll();

    /**
     * 根据手机号码获取销售信息
     *
     * @param phone
     * @return
     */
    CustomerInfo getCustomerInfoByPhone(String phone);

    /**
     * 添加客户信息
     *
     * @param info
     */
    void addCustomerInfo(CustomerInfoForm info);

    /**
     * 客户信息列表
     *
     * @return
     */
    List<CustomerInfo> customerInfoList(PagePO po);

    /**
     * 分页查询销售人员的数目
     *
     * @param po
     * @return
     */
    Integer customerInfoListCount(CustomerListPagePO po);

    /**
     * 根据id 获取客户信息
     *
     * @param id
     * @return
     */
    CustomerInfo getCustomerInfoById(String id);

    /**
     * 根据id删除客户信息
     *
     * @param id
     */
    void delCustomerInfoById(String id);

    /**
     * 修改客户信息
     *
     * @param info
     */
    void editCustomerInfo(CustomerInfoForm info);
}
