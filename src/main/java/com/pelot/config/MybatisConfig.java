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
public class MybatisConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();

        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.pelot.mapper");

        return mapperScannerConfigurer;
    }

}
