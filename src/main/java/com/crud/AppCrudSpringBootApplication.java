package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class AppCrudSpringBootApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(AppCrudSpringBootApplication.class, args);
	}
			
	@Bean
	public OrderedCharacterEncodingFilter characterEncodingFilter() {
	    OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
	    filter.setEncoding("UTF-8");
	    filter.setForceEncoding(true);
	    filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return filter;
	}
	
}
