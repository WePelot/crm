package com.pelot.mapper.salesman.query;

import lombok.Data;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017/9/24 21:03.
 */
@Data
public class ChgPwdDTO {
    /**
     * 新密码
     */
    private String newPwd;

    /**
     * 销售id
     */
    private String salesmanId;

}
