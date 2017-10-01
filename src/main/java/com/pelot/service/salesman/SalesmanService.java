/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.service.salesman;

import com.pelot.enums.ResultEnum;
import com.pelot.exception.SalesmanException;
import com.pelot.form.salesman.AddOrEditCustomerTrackInfoForm;
import com.pelot.form.salesman.CustomerInfoForm;
import com.pelot.manage.SalesmanManage;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.CustomerInfo;
import com.pelot.mapper.salesman.dataobject.CustomerTrackInfo;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.dataobject.StatisticsResult;
import com.pelot.mapper.salesman.query.CustomerListPagePO;
import com.pelot.mapper.salesman.query.CustomerTrackInfoListPagePO;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.utils.StringCommonUtil;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 销售人员登录
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:13
 */
@Service
@Slf4j
public class SalesmanService {
    @Resource
    private SalesmanManage salesmanManage;

    public PageQuery<SalesmanInfo> listSalesmanInfo(SalesmanListPagePO po) {
        return salesmanManage.list(po);
    }

    public void add(SalesmanInfo info) {
        try {
            salesmanManage.add(info);
        } catch (Exception e) {
            log.error("添加销售人员失败,salesmanInfo={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_ADD_FAIL);
        }

    }

    public void chg(SalesmanInfo info) {
        try {
            salesmanManage.chg(info);
        } catch (Exception e) {
            log.error("修改销售人员失败,salesmanInfo={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_CHG_FAIL);
        }
    }

    public SalesmanInfo getSalesmanInfoById(String id) {
        SalesmanInfo result = salesmanManage.getSalesmanInfoById(id);
        if (Objects.isNull(result)) {
            throw new SalesmanException(ResultEnum.SALESMANINFO_NOT_EXIST);
        }
        return result;
    }

    public void delSalesmanById(String id) {
        try {
            salesmanManage.delSalesmanById(id);
        } catch (Exception e) {
            log.error("删除销售人员失败,id={},excetpion={}", id, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_DEL_FAIL);
        }
    }

    public void resetPwd(String id) {
        try {
            salesmanManage.resetPwd(id);
        } catch (Exception e) {
            log.error("销售人员重置密码失败,id={},excetpion={}", id, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_DEL_FAIL);
        }
    }

    public void chgPwd(String newPwd, String id) {
        try {
            salesmanManage.chgPwd(newPwd, id);
        } catch (Exception e) {
            log.error("销售人员重置密码失败,newPwd={},id={},exception={}", newPwd, id, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_DEL_FAIL);
        }
    }

    public SalesmanInfo getSalesmanInfoByQuery(String username, String name, String phone) {
        return salesmanManage.getSalesmanInfoByQuery(username, name, phone);
    }

    public List<SalesmanInfo> findAll() {
        return salesmanManage.findAll();
    }

    public CustomerInfo getCustomerInfoByPhone(String phone) {
        return salesmanManage.getCustomerInfoByPhone(phone);
    }

    public PageQuery<CustomerInfo> listCustomerInfo(CustomerListPagePO po) {
        if (!StringUtils.isEmpty(po.getName())) {
            //            po.setName(StringCommonUtil.replaceBlank(po.getName()));
            po.setName("'%" + po.getName() + "%'");
        }
        return salesmanManage.list(po);
    }

    public CustomerInfo getCustomerInfoById(String id) {
        CustomerInfo result = salesmanManage.getCustomerInfoById(id);
        if (Objects.isNull(result)) {
            throw new SalesmanException(ResultEnum.SALESMANINFO_NOT_EXIST);
        }
        return result;
    }

    @Transactional
    public void delCustomerInfoById(String id) {
        try {
            salesmanManage.delCustomerInfoById(id);
            //删除客户追踪信息
            salesmanManage.delCustomerTrackInfoByCustomerInfoId(id);
        } catch (Exception e) {
            log.error("删除客户信息失败,id={},excetpion={}", id, e);
            throw new SalesmanException(ResultEnum.CUSTOMERINFO_DEL_FAIL);
        }
    }

    public void addCustomerInfo(CustomerInfoForm info) {
        try {
            if (!StringUtils.isEmpty(info.getDesc())) {
                info.setDesc(StringCommonUtil.replaceBlank(info.getDesc()));
            }
            salesmanManage.addCustomerInfo(info);
        } catch (Exception e) {
            log.error("新增客户信息失败,info={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.CUSTOMERINFO_ADD_FAIL);
        }
    }

    public void editCustomerInfo(CustomerInfoForm info) {
        try {
            if (!StringUtils.isEmpty(info.getDesc())) {
                info.setDesc(StringCommonUtil.replaceBlank(info.getDesc()));
            }
            salesmanManage.editCustomerInfo(info);
        } catch (Exception e) {
            log.error("修改客户信息失败,info={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.CUSTOMERINFO_CHG_FAIL);
        }
    }

    public void addCustomerTrackInfo(AddOrEditCustomerTrackInfoForm info) {
        try {
            if (!StringUtils.isEmpty(info.getDesc())) {
                info.setDesc(StringCommonUtil.replaceBlank(info.getDesc()));
            }
            salesmanManage.addCustomerTrackInfo(info);
        } catch (Exception e) {
            log.error("新增客户追踪信息失败,info={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.CUSTOMER_TRACK_INFO_ADD_FAIL);
        }
    }

    public void editCustomerTrackInfo(AddOrEditCustomerTrackInfoForm info) {
        try {
            if (!StringUtils.isEmpty(info.getDesc())) {
                info.setDesc(StringCommonUtil.replaceBlank(info.getDesc()));
            }
            salesmanManage.editCustomerTrackInfo(info);
        } catch (Exception e) {
            log.error("修改客户追踪信息失败,info={},excetpion={}", info, e);
            throw new SalesmanException(ResultEnum.CUSTOMER_TRACK_INFO_CHG_FAIL);
        }
    }

    public void delCustomerTrackInfo(String customerTrackInfoId) {
        try {
            salesmanManage.delCustomerTrackInfo(customerTrackInfoId);
        } catch (Exception e) {
            log.error("删除客户追踪信息失败,customerTrackInfoId={},excetpion={}", customerTrackInfoId, e);
            throw new SalesmanException(ResultEnum.CUSTOMER_TRACK_INFO_DEL_FAIL);
        }
    }

    public CustomerTrackInfo getCustomerTrackInfoById(String customerTrackInfoId) {
        CustomerTrackInfo result = salesmanManage.getCustomerTrackInfoById(customerTrackInfoId);
        if (Objects.isNull(result)) {
            throw new SalesmanException(ResultEnum.CUSTOMER_TRACK_INFO_NOT_EXIST);
        }
        return result;
    }

    public PageQuery<CustomerTrackInfo> listCustomerTrackInfo(CustomerTrackInfoListPagePO po) {
        return salesmanManage.customerTrackInfoList(po);
    }

    /**
     * 信息统计
     *
     * @return
     */
    public List<StatisticsResult> statistics() {
        try {
            return salesmanManage.statistics();
        } catch (Exception e) {
            log.error("获取统计信息失败,excetpion={}", e);
            throw new SalesmanException(ResultEnum.STATISTICS_FAIL);
        }
    }

    public SalesmanInfo getSalesmanInfoWithLeadById(String id) {
        SalesmanInfo result = salesmanManage.getSalesmanInfoWithLeadById(id);
        if (Objects.isNull(result)) {
            throw new SalesmanException(ResultEnum.SALESMANINFO_NOT_EXIST);
        }
        return result;
    }
}
