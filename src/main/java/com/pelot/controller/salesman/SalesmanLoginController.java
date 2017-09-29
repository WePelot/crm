/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.controller.salesman;

import com.pelot.constant.CookieConstant;
import com.pelot.enums.ResultEnum;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.mapper.salesman.query.SalesmanLoginPO;
import com.pelot.service.salesman.SalesmanLoginService;
import com.pelot.service.salesman.SalesmanService;
import com.pelot.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * 销售人员登录
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 14:45
 */
@Controller
@RequestMapping("/user")
public class SalesmanLoginController {

    @Autowired
    private SalesmanLoginService salesmanLoginService;

    @Resource
    public SalesmanService salesmanService;

    /**
     * 登录
     * @param username
     * @param password
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "password", required = false) String password,
        HttpServletResponse response,Map<String,Object> map){
        //1.判断用户名和密码是否正确
        SalesmanInfo salesmanInfo = salesmanLoginService.login(new SalesmanLoginPO(username, password));
        if (Objects.nonNull(salesmanInfo)) {
            //2.写入cookie（token为随机字符串+用户ID+用户身份+ 用户所属上级）
            String uuid = UUID.randomUUID().toString();
            String token = uuid + "_" + salesmanInfo.getId() + "_" + salesmanInfo.getIdentity() + "_" + salesmanInfo.getBelong();
            //3. 将token写入cookie
            CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
            //查询条件
            SalesmanListPagePO po = new SalesmanListPagePO();
            po.setIdentity(salesmanInfo.getIdentity());
            po.setSalesmanId(salesmanInfo.getId());
            po.setBelong(salesmanInfo.getBelong());
            PageQuery<SalesmanInfo> list = salesmanService.listSalesmanInfo(po);
            map.put("list", list);
            map.put("currentPage", po.getPageNo());
            map.put("size", po.getPageSize());
            //3.设置成功后跳转增加销售人员列表的界面
            return new ModelAndView("salesman/salesman_list", map);
        } else {
            //用户名和密码不正确，转入错误页面

            //设置失败后跳转列表页
            map.put("errorMsg", ResultEnum.LOGIN_FAIL.getMsg());
            map.put("redirectUrl", "/html/salesman/login.html");
            return new ModelAndView("common/error", map);
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        //1. 从cookie里查询,获取token
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (Objects.nonNull(cookie)) {
            //2. 清除cookie里的token信息
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        //3.清除成功后跳转成功界面
        map.put("errorMsg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("redirectUrl", "/html/salesman/login.html");
        return new ModelAndView("common/success", map);
    }
}
