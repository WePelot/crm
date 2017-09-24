/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.manage;

import com.pelot.enums.ResultEnum;
import com.pelot.exception.SalesmanException;
import com.pelot.form.admin.SalesmanInfoForm;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.common.PageResolve;
import com.pelot.mapper.salesman.SalesmanMapper;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.mapper.salesman.query.SalesmanLoginPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-20 15:41
 */
@Component
@Slf4j
public class SalesmanManage {

    @Resource
    private SalesmanMapper salesmanMapper;

    /**
     * 管理员登录
     *
     * @param po
     * @return
     */
    public SalesmanInfo login(SalesmanLoginPO po) {
        return salesmanMapper.login(po);
    }

    /**
     * 分页销售人员列表
     *
     * @return
     */
    public PageQuery<SalesmanInfo> list(SalesmanListPagePO po) {
        return PageResolve.page(po, c -> salesmanMapper.salesmanInfolistCount(po), l -> salesmanMapper.salesmanInfolist(po));
    }

    /**
     * 增加销售人员
     *
     * @param infoForm
     * @return
     */
    public SalesmanInfo add(SalesmanInfoForm infoForm) {
        SalesmanInfo result = salesmanMapper.addSalesmanInfo(infoForm);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new SalesmanException(ResultEnum.SALESMANINFO_ADD_CHG_FAIL);
    }

    /**
     * 修改销售人员信息
     *
     * @param infoForm
     * @return
     */
    public SalesmanInfo chg(SalesmanInfoForm infoForm) {
        SalesmanInfo result = salesmanMapper.chgSalesmanInfo(infoForm);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new SalesmanException(ResultEnum.SALESMANINFO_ADD_CHG_FAIL);
    }

    /**
     * 根据id获取销售人员信息
     *
     * @param id
     * @return
     */
    public SalesmanInfo getSalesmanInfoById(String id) {
        SalesmanInfo result = salesmanMapper.getSalesmanInfoById(id);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new SalesmanException(ResultEnum.SALESMANINFO_NOT_EXIST);
    }

    public void delSalesmanById(String id) {
        try{
            salesmanMapper.delSalesmanById(id);
        }catch (Exception e){
            log.error("删除销售人员失败,id={},excetpion={}",id,e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_DEL_FAIL);
        }
    }


    public void resetPwd(String id) {
        try {
            salesmanMapper.resetPwd(id);
        } catch (Exception e) {
            log.error("销售人员重置密码失败,id={},excetpion={}", id, e);
            throw new SalesmanException(ResultEnum.SALESMANINFO_DEL_FAIL);
        }
    }
}
