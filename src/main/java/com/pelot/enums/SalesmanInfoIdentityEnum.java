package com.pelot.enums;

import lombok.Getter;

/**
 * Created by hongcj
 * 2017/9/24 14:03.
 */
@Getter
public enum SalesmanInfoIdentityEnum implements CodeEnum {

    //    0为普通销售，1为销售组长，2为总负责人
    COMMON(0, "普通销售"),
    GROUP_LEADER(1, "销售组长"),
    HEAD_CHARGE(2, "总负责人");

    private Integer code;

    private String msg;

    SalesmanInfoIdentityEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
