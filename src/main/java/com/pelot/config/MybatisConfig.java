/*
 * Copyright (c) 2001-2017 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.pelot.config;

/**
 * mybatis的相关配置
 *
 * @author hongcj
 * @version V1.0
 * @since 2017-09-18 17:33
 */

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
////TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解(网上配置，这里实际不需要用到)
//@AutoConfigureAfter({ MybatisConfiguration.class })
public class MybatisConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.pelot.mapper");

        return mapperScannerConfigurer;
    }

}