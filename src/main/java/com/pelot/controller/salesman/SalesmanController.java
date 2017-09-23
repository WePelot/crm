package com.pelot.controller.salesman;

import com.pelot.exception.SalesmanException;
import com.pelot.form.admin.SalesmanInfoForm;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.query.SalesmanListPagePO;
import com.pelot.service.salesman.SalesmanService;
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
 * 销售人员的操作控制
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 18:59
 */
@Controller
@RequestMapping("/salesman")
public class SalesmanController {
    @Resource
    public SalesmanService salesmanService;

    /**
     * 获取销售人员列表集合
     *
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(SalesmanListPagePO po) {
        PageQuery<SalesmanInfo> list = salesmanService.list(po);
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return new ModelAndView("salesman/salesman_list", map);
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
                salesManInfo = salesmanService.add(info);
            } else {
                salesManInfo = salesmanService.chg(info);
            }
            map.put("salesManInfo", salesManInfo);
            return new ModelAndView("salesman/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }

    }

    /**
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesManInfo = salesmanService.getSalesmanById(id);
            map.put("salesManInfo", salesManInfo);
            return new ModelAndView("salesman/salesman_detail", map);
        } catch (SalesmanException e) {
            map.put("errorMsg", e.getMessage());
            map.put("redirectUrl", "salesman/salesman_list");
            return new ModelAndView("common/error", map);
        }
    }


    @GetMapping("/del")
    public ModelAndView del(@RequestParam String id, Map<String, Object> map) {
        try {
            SalesmanInfo salesManInfo = salesmanService.getSalesmanById(id);
            salesmanService.delSalesmanById(salesManInfo.getId());
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
