package com.pelot.form.salesman;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017/9/24 20:47.
 */
@Data
public class ChgPwdForm {
    @NotEmpty(message = "原密码不能为空")
    private String oldPassword;
    @NotEmpty(message = "新密码不能为空")
    private String newPassword;
}
