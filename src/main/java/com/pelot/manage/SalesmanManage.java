package com.pelot.manage;

import com.pelot.form.salesman.AddOrEditCustomerTrackInfoForm;
import com.pelot.form.salesman.CustomerInfoForm;
import com.pelot.mapper.common.PageQuery;
import com.pelot.mapper.common.PageResolve;
import com.pelot.mapper.salesman.SalesmanMapper;
import com.pelot.mapper.salesman.dataobject.CustomerInfo;
import com.pelot.mapper.salesman.dataobject.CustomerTrackInfo;
import com.pelot.mapper.salesman.dataobject.SalesmanInfo;
import com.pelot.mapper.salesman.dataobject.StatisticsResult;
import com.pelot.mapper.salesman.query.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
    public void add(SalesmanInfo infoForm) {
        salesmanMapper.addSalesmanInfo(infoForm);
    }

    /**
     * 修改销售人员信息
     *
     * @param infoForm
     * @return
     */
    public void chg(SalesmanInfo infoForm) {
        salesmanMapper.chgSalesmanInfo(infoForm);
    }

    /**
     * 根据id获取销售人员信息（不包含所属上级名称）
     *
     * @param id
     * @return
     */
    public SalesmanInfo getSalesmanInfoById(String id) {
        return salesmanMapper.getSalesmanInfoById(id);
    }

    /**
     * 删除销售人员
     *
     * @param id
     */
    public void delSalesmanById(String id) {
        salesmanMapper.delSalesmanById(id);
    }


    /**
     * 密码重置
     *
     * @param id
     */
    public void resetPwd(String id) {
        salesmanMapper.resetPwd(id);
    }

    /**
     * 修改密码
     *
     * @param newPwd
     * @param id
     */
    public void chgPwd(String newPwd, String id) {
        ChgPwdDTO dto = new ChgPwdDTO();
        dto.setNewPwd(newPwd);
        dto.setSalesmanId(id);
        salesmanMapper.chgPwd(dto);
    }

    public SalesmanInfo getSalesmanInfoByPhone(String phone) {
        List<SalesmanInfo> result = salesmanMapper.getSalesmanInfoByPhone(phone);
        if (!CollectionUtils.isEmpty(result)) {
            return result.get(0);
        }
        return null;
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    public SalesmanInfo getSalesmanInfoByUsername(String username) {
        SalesmanInfo result = salesmanMapper.getSalesmanInfoByUsername(username);
        return result;
    }

    /**
     * 根据条件查询销售信息
     *
     * @param username
     * @param name
     * @param phone
     * @return
     */
    public SalesmanInfo getSalesmanInfoByQuery(String username, String name, String phone) {
        SalesmanInfoQueryPO po = new SalesmanInfoQueryPO();
        po.setUsername(username);
        po.setPhone(phone);
        po.setName(name);
        SalesmanInfo result = salesmanMapper.getSalesmanInfoByQuery(po);
        return result;
    }

    /**
     * 查詢所有的銷售信息
     *
     * @return
     */
    public List<SalesmanInfo> findAll() {
        return salesmanMapper.findAll();
    }

    /**
     * 根据手机号码查询客户信息
     *
     * @param phone
     * @return
     */
    public CustomerInfo getCustomerInfoByPhone(String phone) {
        List<CustomerInfo> result = salesmanMapper.getCustomerInfoByPhone(phone);
        if (!CollectionUtils.isEmpty(result)) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据id获取客户信息
     *
     * @param id
     * @return
     */
    public CustomerInfo getCustomerInfoById(String id) {
        return salesmanMapper.getCustomerInfoById(id);
    }

    /**
     * 添加客户信息
     *
     * @param info
     */
    public void addCustomerInfo(CustomerInfoForm info) {
        salesmanMapper.addCustomerInfo(info);
    }

    /**
     * 分页客户信息列表
     *
     * @return
     */
    public PageQuery<CustomerInfo> list(CustomerListPagePO po) {
        return PageResolve.page(po, c -> salesmanMapper.customerInfoListCount(po), l -> salesmanMapper.customerInfoList(po));
    }

    /**
     * 删除客户信息
     *
     * @param id
     */
    public void delCustomerInfoById(String id) {
        salesmanMapper.delCustomerInfoById(id);
    }

    /**
     * 修改客户信息
     *
     * @param info
     */
    public void editCustomerInfo(CustomerInfoForm info) {
        salesmanMapper.editCustomerInfo(info);
    }

    /**
     * 分页获取客户追踪信息列表
     *
     * @return
     */
    public PageQuery<CustomerTrackInfo> customerTrackInfoList(CustomerTrackInfoListPagePO po) {
        return PageResolve.page(po, c -> salesmanMapper.customerTrackInfoListCount(po),
            l -> salesmanMapper.customerTrackInfoList(po));
    }

    /**
     * 增加客户追踪信息
     *
     * @param info
     */
    public void addCustomerTrackInfo(AddOrEditCustomerTrackInfoForm info) {
        salesmanMapper.addCustomerTrackInfo(info);
    }

    /**
     * 删除客户追踪信息
     *
     * @param customerTrackInfoId
     */
    public void delCustomerTrackInfo(String customerTrackInfoId) {
        salesmanMapper.delCustomerTrackInfo(customerTrackInfoId);
    }

    /**
     * 根据id获取客户追踪信息
     *
     * @param customerTrackInfoId
     * @return
     */
    public CustomerTrackInfo getCustomerTrackInfoById(String customerTrackInfoId) {
        return salesmanMapper.getCustomerTrackInfoById(customerTrackInfoId);
    }

    /**
     * 修改客户追踪信息
     *
     * @param info
     */
    public void editCustomerTrackInfo(AddOrEditCustomerTrackInfoForm info) {
        salesmanMapper.editCustomerTrackInfo(info);
    }

    public void delCustomerTrackInfoByCustomerInfoId(String customerInfoId) {
        salesmanMapper.delCustomerTrackInfoByCustomerInfoId(customerInfoId);
    }

    /**
     * 信息统计
     *
     * @return
     */
    public List<StatisticsResult> statistics() {
        return salesmanMapper.statistics();
    }

    /**
     * 根据销售id获取销售信息（包含所属上级名称）
     *
     * @param id
     * @return
     */
    public SalesmanInfo getSalesmanInfoWithLeadById(String id) {
        return salesmanMapper.getSalesmanInfoWithLeadById(id);
    }
}
