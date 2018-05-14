package com.pelot.mapper.salesman.query;

import lombok.Data;

/**
 * 管理员登录po
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:04
 */
@Data
public class SalesmanLoginPO {
    private String username;

    private String password;

    public SalesmanLoginPO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
