package com.pelot;

/**
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 13:33
 */

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 * @author hongcj
 * @version V1.0
 * @since 2017-07-19 14:24
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(CrmApplication.class);
    }
}
