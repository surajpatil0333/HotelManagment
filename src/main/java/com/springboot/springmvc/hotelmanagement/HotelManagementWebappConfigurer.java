package com.springboot.springmvc.hotelmanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HotelManagementWebappConfigurer implements WebMvcConfigurer {

	public HotelManagementWebappConfigurer() {
		// TODO Auto-generated constructor stub
	}
@Override
public void addInterceptors(InterceptorRegistry registry)
{
	registry.addInterceptor(new MyInterceptor()).addPathPatterns("/secure/*");
}
}
