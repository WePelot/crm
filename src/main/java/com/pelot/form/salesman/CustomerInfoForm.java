package com.pelot.form.salesman;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-07-19 14:24
 */
@Data
public class CustomerInfoForm {
    /**
     * ID
     */
    private String id;

    /**
     * 所属销售
     */
    @NotEmpty(message = "置业顾问不能为空")
    private String salesmanId;

    /**
     * 接待时间
     */
    @NotEmpty(message = "接待时间不能为空")
    private String receptionTime;

    /**
     * 代理公司
     */
    private String company;

    /**
     * 姓名
     */
    @NotEmpty(message = "客户姓名不能为空")
    private String name;

    /**
     * 客户电话
     */
    @NotEmpty(message = "客户电话不能为空")
    private String phone;

    /**
     * 性别，1为男，2为女
     */
    @NotNull(message = "客户姓名不能为空")
    private Integer sex;

    /**
     * 年龄区间，1为25以下
     */
    private String ageRange;

    /**
     * 家庭结构
     */
    private String familyStructure;

    /**
     * 居住区域
     */
    private String residentialRegion;

    /**
     * 居住小区
     */
    private String residentialDistrict;

    /**
     * 工作区域
     */
    private String workingArea;

    /**
     * 获知渠道
     */
    private String msgAccess;

    /**
     * 单位分类
     */
    private String companyType;

    /**
     * 职务
     */
    private String job;

    /**
     * 首选产品
     */
    private String preferredProduct;

    /**
     * 首选面积
     */
    private String preferredArea;

    /**
     * 意向单价
     */
    private String psychologicalUnitPrice;

    /**
     * 意向总价
     */
    private String psychologicalTotalPrice;

    /**
     * 购房动机
     */
    private String reason;

    /**
     * 付款方式
     */
    private String payWay;

    /**
     * 出行工具
     */
    private String tripTools;

    /**
     * 关键因素
     */
    private String keyFactor;

    /**
     * 置业次数
     */
    private String askingTime;

    /**
     * 贷款次数
     */
    private String loanTime;

    /**
     * 客户意愿
     */
    private String willingness;

    /**
     * 客户描述
     */
    private String desc;


}
