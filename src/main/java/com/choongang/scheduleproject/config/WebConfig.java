package com.choongang.scheduleproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.choongang.scheduleproject.interceptor.AdminAuthHandler;

@Configuration //스프링 빈 설정
public class WebConfig implements WebMvcConfigurer{

	@Bean
	public AdminAuthHandler adminAuthHandler() {
		return new AdminAuthHandler();
	}


	//WebMvcConfigurer 클래스가 제공해주는 인터셉터 추가 함수

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthHandler())
				.addPathPatterns("/admin/*")
				.excludePathPatterns("/")
				.excludePathPatterns("/admin/login");
	}


}
