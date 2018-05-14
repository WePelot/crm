package com.pelot.VO;

import java.io.Serializable;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-07-17 11:09
 */
@Data
public class ResultVO<T>  implements Serializable{

    private static final long serialVersionUID = 3068837394742385883L;
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回的具体内容
     */
    private T data;

}
