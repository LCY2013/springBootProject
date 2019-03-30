package com.lcydream.project.springbootjdbc.flux.fluxconfiguration;

import com.lcydream.project.springbootjdbc.flux.fluxhandler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * WebFluxConfiguration
 * webFlux配置类
 * @author Luo Chun Yun
 * @date 2018/11/24 19:48
 */
@Configuration
public class WebFluxConfiguration {

	@Bean
	public RouterFunction<ServerResponse> saveUser(UserHandler userHandler){
		return route(POST("/web/flux/user/save"),userHandler::save);
	}
}
