package com.pelot.form.salesman;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 19:31
 */

@Data
public class ChgSalesmanInfoForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "联系号码不能为空")
    private String phone;

}
