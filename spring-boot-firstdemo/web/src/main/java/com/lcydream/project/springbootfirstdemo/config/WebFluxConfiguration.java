package com.lcydream.project.springbootfirstdemo.config;

import com.lcydream.project.springbootfirstdemo.domain.User;
import com.lcydream.project.springbootfirstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * WebFluxConfiguration
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/1 17:02
 */
@Configuration
public class WebFluxConfiguration {

	@Bean
	@Autowired
	public RouterFunction<ServerResponse> routerFunctionUsers(UserRepository userRepository){
		Collection<User> userCollection = userRepository.getAll();
		Flux<User> userFlux = Flux.fromIterable(userCollection);
		//Mono<Collection<User>> userMono = Mono.just(userCollection);

		return RouterFunctions.route(RequestPredicates.path("/users")
		,serverRequest -> ServerResponse.ok().body(userFlux,User.class));
	}
}
