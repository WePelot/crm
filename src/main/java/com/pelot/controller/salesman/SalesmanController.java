package com.pelot.controller.salesman;

import com.pelot.controller.base.BaseController;
import com.pelot.enums.ResultEnum;
import com.pelot.exception.SalesmanException;
import com.pelot.form.salesman.AddSalesmanInfoForm;
import com.pelot.form.salesman.ChgPwdForm;
import com.pelot.form.salesman.ChgSalesmanInfoForm;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.service.salesman.SalesmanService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
 * 销售人员的操作控制
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 18:59
 */
@Controller
@RequestMapping("/salesman")
public class SalesmanController extends BaseController {
    @Resource
    public SalesmanService salesmanService;

    /**
     * 获取销售人员列表集合
     * 前端传过来的po里只有pageNo和pageSize
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(SalesmanListPagePO po) {
        po.setIdentity(getIdentity());
        po.setSalesmanId(getUserId());
        //总负责人的上级为null
        po.setBelong(getBelong());
        PageQuery<SalesmanInfo> list = salesmanService.list(po);
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        //在查询时会将page减1，所以这里需要加1
        map.put("currentPage", po.getPageNo() + 1);
        map.put("size", po.getPageSize());
        return new ModelAndView("salesman/salesman_list", map);
    }

    /**
     * 新增
     *
     * @param info
     * @param map
     * @return
     */
    @PostMapping("/add")
    public ModelAndView save(@Valid AddSalesmanInfoForm info, BindingResult bindingResult, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            SalesmanInfo salesmanInfo = new SalesmanInfo();
            salesmanInfo.setUsername(info.getUsername());
            salesmanInfo.setPassword(info.getPassword());
            salesmanInfo.setName(info.getName());
            salesmanInfo.setBelong(info.getBelong());
            //为空说明是修改是新增
            salesmanService.add(salesmanInfo);
            map.put("salesmanInfo", salesmanInfo);
            return new ModelAndView("salesman/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }


    /**
     * 跳转修改个人信息的页面
     *
     * @return
     */
    @GetMapping("/toChgMsg")
    public ModelAndView toChgMsg(Map<String, Object> map) {
        SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
        map.put("salesmanInfo", salesmanInfo);
        return new ModelAndView("salesman/salesman_toChgMsg", map);
    }

    /**
     * 修改个人信息
     *
     * @param info
     * @param map
     * @return
     */
    @PostMapping("/chgMsg")
    public ModelAndView chgMsg(@Valid ChgSalesmanInfoForm info, BindingResult bindingResult, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
            salesmanInfo.setName(info.getName());
            salesmanInfo.setPhone(info.getPhone());
            salesmanService.chg(salesmanInfo);
            map.put("salesmanInfo", salesmanInfo);
            return new ModelAndView("salesman/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(Map<String, Object> map) {
        try {
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
            map.put("salesmanInfo", salesmanInfo);
            return new ModelAndView("salesman/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }


    @GetMapping("/del")
    public ModelAndView del(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(id);
            salesmanService.delSalesmanById(salesmanInfo.getId());
            map.put("errorMsg", "删除成功");
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }


    @GetMapping("/resetPwd")
    public ModelAndView resetPwd(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(id);
            salesmanService.resetPwd(salesmanInfo.getId());
            map.put("errorMsg", "密码重置成功");
            map.put("redirectUrl", "/salesman/list?pageNo=1&pageSize=20");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/list?pageNo=1&pageSize=20");
            return new ModelAndView("common/error", map);
        }
    }


    /**
     * 跳转修改个人密码的页面
     *
     * @return
     */
    @GetMapping("/toChgPwd")
    public ModelAndView toChgPwd() {
        return new ModelAndView("salesman/salesman_toChgPwd");
    }

    /**
     * 修改密码
     *
     * @param form
     * @param map
     * @return
     */
    @PostMapping("/chgPwd")
    public ModelAndView chgPwd(@Valid ChgPwdForm form, BindingResult bindingResult, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
            if (form.getOldPwd().equals(salesmanInfo.getPassword())) {
                salesmanService.chgPwd(form.getNewPwd(), getUserId());
                map.put("errorMsg", "密码修改成功");
                map.put("redirectUrl", "/salesman/list?pageNo=1&pageSize=20");
                return new ModelAndView("common/success", map);
            } else {
                map.put("errorMsg", "原密码输入不正确");
                map.put("redirectUrl", "/salesman/toChgPwd");
                return new ModelAndView("common/error", map);
            }
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/toChgPwd");
            return new ModelAndView("common/error", map);
        }
    }

}
