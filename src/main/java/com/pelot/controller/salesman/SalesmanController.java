package com.pelot.controller.salesman;

import com.pelot.VO.ResultVO;
import com.pelot.constant.CookieConstant;
import com.pelot.controller.base.BaseController;
import com.pelot.enums.ResultEnum;
import com.pelot.exception.SalesmanException;
import com.pelot.form.salesman.AddOrEditCustomerTrackInfoForm;
import com.pelot.form.salesman.AddSalesmanInfoForm;
import com.pelot.form.salesman.ChgPwdForm;
import com.pelot.form.salesman.ChgSalesmanInfoForm;
import com.pelot.form.salesman.CustomerInfoForm;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.CustomerInfo;
import com.pelot.mapper.salesman.dataobject.CustomerTrackInfo;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.CustomerListPagePO;
import com.pelot.mapper.salesman.query.CustomerTrackInfoListPagePO;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.service.salesman.SalesmanService;
import com.pelot.utils.CookieUtil;
import com.pelot.utils.ResultVOUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

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
    @GetMapping("/listSalesmanInfo")
    public ModelAndView listSalesmanInfo(SalesmanListPagePO po) {
        po.setIdentity(getIdentity());
        po.setSalesmanId(getUserId());
        //总负责人的上级为null
        po.setBelong(getBelong());
        PageQuery<SalesmanInfo> list = salesmanService.listSalesmanInfo(po);
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
            //判断手机号码是否存在，前面已经做校验，这里就不做二次校验了
//            SalesmanInfo salesmanInfoByPhone = salesmanService.getSalesmanInfoByPhone(info.getPhone());
//            if (Objects.nonNull(salesmanInfoByPhone)) {
//                map.put("errorMsg", "该手机号码已经被其他销售人员绑定，请重新输入");
//                map.put("redirectUrl", "/salesman/toAddSalesman");
//                return new ModelAndView("common/error", map);
//            }
            SalesmanInfo salesmanInfo = new SalesmanInfo();
            salesmanInfo.setUsername(info.getUsername());
            salesmanInfo.setName(info.getName());
            salesmanInfo.setBelong(getUserId());
            salesmanInfo.setPhone(info.getPhone());
            salesmanInfo.setIdentity(Integer.parseInt(info.getIdentity()));
            salesmanService.add(salesmanInfo);
            map.put("errorMsg", "添加成功");
            map.put("redirectUrl", "/salesman/listSalesmanInfo?pageNo=1&pageSize=20");
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


    @GetMapping("/delSalesman")
    public ModelAndView delSalesman(@RequestParam String id, Map<String, Object> map) {
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
            map.put("redirectUrl", "/salesman/listSalesmanInfo?pageNo=1&pageSize=20");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listSalesmanInfo?pageNo=1&pageSize=20");
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
    @GetMapping("/checkSalesmanInfoByQuery")
    @ResponseBody
    public ResultVO checkSalesmanInfoByQuery(@RequestParam String phone, @RequestParam String username, @RequestParam String name) {
        SalesmanInfo salesmanInfoByQuery = salesmanService.getSalesmanInfoByQuery(username, name, phone);
        if (Objects.isNull(salesmanInfoByQuery)) {
            return ResultVOUtil.success();
        } else if (username.equals(salesmanInfoByQuery.getUsername())) {
            return ResultVOUtil.error(-1, "该用户名已存在");
        } else if (name.equals(salesmanInfoByQuery.getName())) {
            return ResultVOUtil.error(-1, "该姓名已存在");
        } else if (phone.equals(salesmanInfoByQuery.getPhone())) {
            return ResultVOUtil.error(-1, "该手机号码已存在");
        }
        return ResultVOUtil.success();
    }


    /**
     * 跳转新增新客户信息界面
     *
     * @return
     */
    @GetMapping("/toAddCustomer")
    public ModelAndView toAddCustomer(Map<String, Object> map) {
        try {
            map.put("currentId", getUserId());
            List<SalesmanInfo> list = salesmanService.findAll();
            map.put("list", list);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/html/salesman/login.html");
            return new ModelAndView("common/error", map);
        }
        return new ModelAndView("salesman/salesman_addCustomer", map);
    }

    /**
     * 跳转编辑新客户信息界面
     *
     * @return
     */
    @GetMapping("/toEditCustomer")
    public ModelAndView toEditCustomer(@RequestParam(value = "id", required = false) String id, Map<String, Object> map) {
        try {
            CustomerInfo customerInfo = salesmanService.getCustomerInfoById(id);
            map.put("customerInfo", customerInfo);
            map.put("currentId", customerInfo.getSalesmanId());
            List<SalesmanInfo> list = salesmanService.findAll();
            map.put("list", list);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/html/salesman/login.html");
            return new ModelAndView("common/error", map);
        }
        return new ModelAndView("salesman/salesman_editCustomer", map);
    }



    /**
     * 新增客户信息
     *
     * @param info
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/saveCustomerInfo")
    public ModelAndView saveCustomerInfo(@Valid CustomerInfoForm info, BindingResult bindingResult, Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            if (StringUtils.isEmpty(info.getId())) {
                //判断手机号码是否存在
                CustomerInfo customerInfoByPhone = salesmanService.getCustomerInfoByPhone(info.getPhone());
                if (Objects.nonNull(customerInfoByPhone)) {
                    map.put("errorMsg", "该手机号码已经存在，请重新输入");
                    map.put("redirectUrl", "/salesman/toAddCustomer");
                    return new ModelAndView("common/error", map);
                }
                //为空，说明为新增
                salesmanService.addCustomerInfo(info);
                map.put("errorMsg", "添加成功");
            } else {
                //不为空，修改
                //先判断对应的id是否存在
                CustomerInfo customerInfoById = salesmanService.getCustomerInfoById(info.getId());
                //判断手机是否有修改
                if (!customerInfoById.getPhone().equals(info.getPhone())) {
                    //手机号相同，则为同一个人，无需判断手机号是否存在
                    //判断手机号码是否存在
                    CustomerInfo customerInfoByPhone = salesmanService.getCustomerInfoByPhone(info.getPhone());
                    if (Objects.nonNull(customerInfoByPhone)) {
                        map.put("errorMsg", "该手机号码已经存在，请重新输入");
                        map.put("redirectUrl", "/salesman/toEditCustomer");
                        return new ModelAndView("common/error", map);
                    }
                }
                salesmanService.editCustomerInfo(info);
                map.put("errorMsg", "修改成功");
            }
            map.put("redirectUrl", "/salesman/listCustomerInfo?pageNo=1&pageSize=20");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 校验手机号是否存在
     *
     * @param phone
     * @return
     */
    @GetMapping("/checkCustomerInfoByPhone")
    @ResponseBody
    public ResultVO checkCustomerInfoByPhone(@RequestParam String phone) {
        CustomerInfo customerInfoByPhone = salesmanService.getCustomerInfoByPhone(phone);
        if (Objects.isNull(customerInfoByPhone)) {
            return ResultVOUtil.success();
        } else {
            return ResultVOUtil.error(-1, "该手机号码已存在");
        }
    }


    /**
     * 获取客户信息集合
     *
     * @param po
     * @return
     */
    @GetMapping("/listCustomerInfo")
    public ModelAndView listCustomerInfo(CustomerListPagePO po) {
        po.setSalesmanId(getUserId());
        PageQuery<CustomerInfo> list = salesmanService.listCustomerInfo(po);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        //在查询时会将page减1，所以这里需要加1
        map.put("currentPage", po.getPageNo() + 1);
        map.put("size", po.getPageSize());
        map.put("salesmanId", po.getSalesmanId());
        return new ModelAndView("salesman/customer_list", map);
    }


    /**
     * 删除客户信息
     *
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/delCustomerInfo")
    public ModelAndView delCustomerInfo(@RequestParam String id, Map<String, Object> map) {
        try {
            CustomerInfo customerInfo = salesmanService.getCustomerInfoById(id);
            salesmanService.delCustomerInfoById(customerInfo.getId());
            map.put("errorMsg", "删除成功");
            map.put("redirectUrl", "/salesman/listCustomerInfo");
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listCustomerInfo");
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 客户信息详情
     *
     * @param id  客户ID
     * @param map
     * @return
     */
    @GetMapping("/customerInfoDetail")
    public ModelAndView customerInfoDetail(@RequestParam(value = "id", required = false) String id, Map<String, Object> map) {
        try {
            CustomerInfo customerInfo = salesmanService.getCustomerInfoById(id);
            SalesmanInfo salesmanInfo = salesmanService.getSalesmanInfoById(getUserId());
            map.put("customerInfo", customerInfo);
            map.put("salesmanName", salesmanInfo.getName());
            return new ModelAndView("salesman/customer_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listCustomerInfo");
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 跳转新增新客户追踪信息界面
     *
     * @return
     */
    @GetMapping("/toAddCustomerTrackInfo")
    public ModelAndView toAddCustomer(@RequestParam(value = "customerInfoId", required = false) String customerInfoId,
        Map<String, Object> map) {
        map.put("customerInfoId", customerInfoId);
        return new ModelAndView("salesman/salesman_addCustomerTrack", map);
    }

    /**
     * 获取客户追踪信息集合
     *
     * @param po
     * @return
     */
    @GetMapping("/listCustomerTrackInfo")
    public ModelAndView listCustomerTrackInfo(CustomerTrackInfoListPagePO po) {
        PageQuery<CustomerTrackInfo> list = salesmanService.listCustomerTrackInfo(po);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        //在查询时会将page减1，所以这里需要加1
        map.put("currentPage", po.getPageNo() + 1);
        map.put("size", po.getPageSize());
        map.put("customerInfoId", po.getCustomerInfoId());
        return new ModelAndView("salesman/customer_track_list", map);
    }

    /**
     * 新增客户信息
     *
     * @param info
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/saveCustomerTrackInfo")
    public ModelAndView saveCustomerTrackInfo(@Valid AddOrEditCustomerTrackInfoForm info, BindingResult bindingResult,
        Map<String, Object> map) {
        try {
            if (bindingResult.hasErrors()) {
                throw new SalesmanException(ResultEnum.PARAM_ERROR);
            }
            if (StringUtils.isEmpty(info.getCustomerInfoId())) {
                //为空，说明为新增
                salesmanService.addCustomerTrackInfo(info);
                map.put("errorMsg", "添加成功");
            } else {
                //不为空，修改
                //先判断对应的id是否存在
                CustomerInfo customerInfoById = salesmanService.getCustomerInfoById(info.getCustomerInfoId());
                if (Objects.nonNull(customerInfoById)) {
                    salesmanService.editCustomerTrackInfo(info);
                }
                map.put("errorMsg", "修改成功");
            }
            map.put("redirectUrl", "/salesman/listCustomerTrackInfo?customerInfoId=" + info.getCustomerInfoId());
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listCustomerTrackInfo?customerInfoId=" + info.getCustomerInfoId());
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 删除客户追踪信息
     *
     * @param customerTrackInfoId
     * @param map
     * @return
     */
    @GetMapping("/delCustomerTrackInfo")
    public ModelAndView delCustomerTrackInfo(@RequestParam String customerTrackInfoId,
        @RequestParam String customerInfoId, Map<String, Object> map) {
        try {
            CustomerTrackInfo customerTrackInfoById = salesmanService.getCustomerTrackInfoById(customerTrackInfoId);
            salesmanService.delCustomerTrackInfo(customerTrackInfoById.getId());
            map.put("errorMsg", "删除成功");
            map.put("redirectUrl", "/salesman/listCustomerTrackInfo?customerInfoId=" + customerInfoId);
            return new ModelAndView("common/success", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listCustomerTrackInfo?customerInfoId=" + customerInfoId);
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 客户追踪信息详情
     *
     * @param map
     * @return
     */
    @GetMapping("/customerTrackInfoDetail")
    public ModelAndView customerTrackInfoDetail(@RequestParam String customerTrackInfoId,
        @RequestParam String customerInfoId, Map<String, Object> map) {
        try {
            CustomerTrackInfo customerTrackInfo = salesmanService.getCustomerTrackInfoById(customerTrackInfoId);
            map.put("customerTrackInfo", customerTrackInfo);
            return new ModelAndView("salesman/customer_track_info_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "/salesman/listCustomerTrackInfo?customerInfoId=" + customerInfoId);
            return new ModelAndView("common/error", map);
        }
    }


}
