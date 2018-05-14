package com.pelot.form.salesman;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 客户最终信息添加
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-29 14:35
 */
@Data
public class AddOrEditCustomerTrackInfoForm {

    /**
     * 客户追踪信息id
     */
    private String customerTrackInfoId;

    /**
     * 客户信息ID
     */
    @NotEmpty(message = "客户信息id不能为空")
    private String customerInfoId;

    /**
     * 具体事项
     */
    @NotEmpty(message = "具体事项不能为空")
    private String desc;
}
