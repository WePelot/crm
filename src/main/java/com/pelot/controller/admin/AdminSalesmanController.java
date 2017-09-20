/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.controller.admin;

import com.pelot.exception.SalesmanException;
import com.pelot.form.admin.SalesmanInfoForm;
import com.pelot.manage.AdminManage;
import com.pelot.mapper.admin.dataobject.SalesmanInfo;
import com.pelot.mapper.common.PagePO;
import com.pelot.mapper.common.PageQuery;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 18:59
 */
@Controller
@RequestMapping("/admin/salesman")
public class AdminSalesmanController {
    @Resource
    public AdminManage adminManage;

    /**
     * 获取销售人员列表集合
     *
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(PagePO po) {
        PageQuery<SalesmanInfo> list = adminManage.list(po);
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return new ModelAndView("admin/salesman_list",map);
    }

    /**
     * 新增或修改销售人员信息
     *
     * @param info
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid SalesmanInfoForm info, Map<String, Object> map) {
        try {
            SalesmanInfo salesManInfo = null;
            if (StringUtils.isEmpty(info.getId())) {
                //为空说明是修改是新增
                salesManInfo = adminManage.add(info);
            } else {
                salesManInfo = adminManage.chg(info);
            }
            map.put("salesManInfo", salesManInfo);
            return new ModelAndView("admin/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "admin/salesman_list");
            return new ModelAndView("common/error", map);
        }

    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesManInfo = adminManage.getSalesmanById(id);
            map.put("salesManInfo", salesManInfo);
            return new ModelAndView("admin/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "admin/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }


    @GetMapping("/del")
    public ModelAndView del(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesManInfo = adminManage.getSalesmanById(id);
            adminManage.delSalesmanById(salesManInfo.getId());
            map.put("errorMsg", "删除成功");
            map.put("redirectUrl", "admin/salesman_list");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "admin/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }
}
