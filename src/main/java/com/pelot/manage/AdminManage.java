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
import com.pelot.mapper.admin.AdminMapper;
import com.pelot.mapper.admin.dataobject.AdminInfo;
import com.pelot.mapper.admin.dataobject.SalesmanInfo;
import com.pelot.mapper.admin.query.AdminLoginPO;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-20 15:41
 */
@Component
public class AdminManage {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 管理员登录
     *
     * @param po
     * @return
     */
    public AdminInfo login(AdminLoginPO po) {
        return adminMapper.login(po);
    }

    /**
     * 销售人员列表
     *
     * @return
     */
    public List<SalesmanInfo> list() {
        return adminMapper.list();
    }

    /**
     * 增加销售人员
     *
     * @param infoForm
     * @return
     */
    public SalesmanInfo add(SalesmanInfoForm infoForm) {
        SalesmanInfo result = adminMapper.add(infoForm);
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
        SalesmanInfo result = adminMapper.chg(infoForm);
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
    public SalesmanInfo getSalesmanById(String id) {
        SalesmanInfo result = adminMapper.getSalesmanById(id);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new SalesmanException(ResultEnum.SALESMANINFO_NOT_EXIST);
    }
}
