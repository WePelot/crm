package com.pelot.form.salesman;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by hongcj
 * 2017/9/24 20:47.
 */
@Data
public class ChgPwdForm {
    @NotEmpty(message = "原密码不能为空")
    private String oldPwd;
    @NotEmpty(message = "新密码不能为空")
    private String newPwd;
}
