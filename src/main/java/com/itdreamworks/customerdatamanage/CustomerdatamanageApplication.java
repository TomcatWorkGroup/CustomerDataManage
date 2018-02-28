package com.itdreamworks.customerdatamanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.itdreamworks.customerdatamanage.mapper2")
public class CustomerdatamanageApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomerdatamanageApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(CustomerdatamanageApplication.class, args);
	}
}
