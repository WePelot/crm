/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved. 
 * This software is the confidential and proprietary information of GuaHao Company. 
 * ("Confidential Information"). 
 * You shall not disclose such Confidential Information and shall use it only 
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.form.admin;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-09-19 19:31
 */

@Data
public class SalesmanInfoForm {

    private String id;

    @NotEmpty(message = "姓名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "联系号码不能为空")
    private String phone;

}
