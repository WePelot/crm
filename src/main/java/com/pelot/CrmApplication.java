package com.pelot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author hongcj
 * @version V1.0
 * @since 2017-07-19 14:24
 */
@SpringBootApplication
@ServletComponentScan
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
}
