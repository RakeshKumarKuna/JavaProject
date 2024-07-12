package com.krk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

@SpringBootApplication
public class WareHouseAppApplication {
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver bean=new BeanNameViewResolver();
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(WareHouseAppApplication.class, args);
	}

}
