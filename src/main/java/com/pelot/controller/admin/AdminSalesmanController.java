/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.controller.admin;

import com.pelot.form.admin.SalesManInfoForm;
import com.pelot.mapper.admin.AdminMapper;
import com.pelot.mapper.admin.dataobject.SalesManInfo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 18:59
 */
@Controller
@RequestMapping("/admin/salesman")
public class AdminSalesmanController {
    @Resource
    public AdminMapper adminMapper;

    /**
     * 获取销售人员列表集合
     *
     * @return
     */
    @PostMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<SalesManInfo> list = adminMapper.list();
        map.put("list", list);
        return new ModelAndView("admin/salesman_list");
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid SalesManInfoForm info) {
        return new ModelAndView();
    }
}
