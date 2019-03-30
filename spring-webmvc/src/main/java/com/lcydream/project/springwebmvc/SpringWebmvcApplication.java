package com.lcydream.project.springwebmvc;

import com.lcydream.project.springwebmvc.interceptor.DefaultDemoInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LuoCY
 */
@SpringBootApplication
public class SpringWebmvcApplication implements WebMvcConfigurer, ErrorPageRegistrar {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebmvcApplication.class, args);
	}

	/**
	 * 添加默认拦截器
	 * @param registry 注册消息
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DefaultDemoInterceptor());
	}


	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
    registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
		    "/404.html"));
	}
}
