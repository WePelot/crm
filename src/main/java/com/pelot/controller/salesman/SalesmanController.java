package com.pelot.controller.salesman;

import com.pelot.VO.ResultVO;
import com.pelot.constant.CookieConstant;
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
import com.pelot.utils.CookieUtil;
import com.pelot.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 销售人员的操作控制
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 18:59
 */
@Controller
@RequestMapping("/salesman")
@Slf4j
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
     * 跳转修改个人信息的页面
     *
     * @return
     */
    @GetMapping("/toAddSalesman")
    public ModelAndView toAddSalesman(Map<String, Object> map) {
        //获取身份，用户界面上判断
        Integer identity = getIdentity();
        map.put("identity", identity);
        return new ModelAndView("salesman/salesman_add", map);
    }

    /**
     * 新增
     *
     * @param info
     * @param map
     * @return
     */
    @PostMapping("/add")
    public ModelAndView add(@Valid AddSalesmanInfoForm info, BindingResult bindingResult, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            //判断手机号码是否存在
            SalesmanInfo salesmanInfoByPhone = salesmanService.getSalesmanInfoByPhone(info.getPhone());
            if (Objects.nonNull(salesmanInfoByPhone)) {
                map.put("errorMsg", "该手机号码已经被其他销售人员绑定，请重新输入");
                map.put("redirectUrl", "/salesman/toAddSalesman");
                return new ModelAndView("common/error", map);
            }
            SalesmanInfo salesmanInfo = new SalesmanInfo();
            salesmanInfo.setUsername(info.getUsername());
            salesmanInfo.setName(info.getName());
            salesmanInfo.setBelong(getUserId());
            salesmanInfo.setPhone(info.getPhone());
            salesmanInfo.setIdentity(Integer.parseInt(info.getIdentity()));
            salesmanService.add(salesmanInfo);
            map.put("errorMsg", "添加成功");
            map.put("redirectUrl", "/salesman/list?pageNo=1&pageSize=20");
            return new ModelAndView("common/success", map);
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
    public ModelAndView chgPwd(@Valid ChgPwdForm form, BindingResult bindingResult,
                               HttpServletResponse response, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                log.error("修改密码参数错误,错误信息={}", bindingResult.getFieldError().getDefaultMessage());
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
            if (form.getOldPassword().equals(salesmanInfo.getPassword())) {
                salesmanService.chgPwd(form.getNewPassword(), getUserId());
                map.put("errorMsg", "密码修改成功，请重新登录");
                //密码修改成功，去除token，跳转到登录页
                //1. 从cookie里查询,获取token
                Cookie cookie = getToken();
                if (Objects.nonNull(cookie)) {
                    //2. 清除cookie里的token信息
                    CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
                }
                map.put("redirectUrl", "/html/salesman/login.html");
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

    /**
     * 校验用户名和手机号是否存在
     *
     * @param phone
     * @param username
     * @return
     */
    @GetMapping("/checkSalesmanInfoByUsernameAndPhone")
    @ResponseBody
    public ResultVO checkSalesmanInfoByUsernameAndPhone(@RequestParam String phone, @RequestParam String username) {
        SalesmanInfo salesmanInfoByUsername = salesmanService.getSalesmanInfoByUsername(username);
        if (Objects.nonNull(salesmanInfoByUsername)) {
            //存在该手机号码绑定的销售人员
            return ResultVOUtil.error(-1, "该用户名已存在");
        } else {
            SalesmanInfo salesmanInfoByPhone = salesmanService.getSalesmanInfoByPhone(phone);
            if (Objects.nonNull(salesmanInfoByPhone)) {
                //存在该手机号码绑定的销售人员
                return ResultVOUtil.error(-1, "该手机号码已存在");
            } else {
                return ResultVOUtil.success();
            }
        }
    }

}
