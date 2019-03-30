package com.lcydream.project.springbootjdbc.flux.fluxhandler;

import com.lcydream.project.springbootjdbc.domain.User;
import com.lcydream.project.springbootjdbc.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * UserHandler
 * SpringFlux 需要的处理器
 * @author Luo Chun Yun
 * @date 2018/11/24 19:50
 */
@Component
public class UserHandler {

	private final UserRepository userRepository;

	public UserHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Mono<ServerResponse> save(ServerRequest serverRequest){
		System.out.printf("[SpringFlux Thread: %s ]\n",
				Thread.currentThread().getName());
		//在Spring Web MVC中使用@RequestBody自动注入pojo参数
		//在Spring Web Flux中使用ServerRequest自动注入参数
		//Mono<User>类似于Optional<User>
		//Flux<User>类似于List<User>
		Mono<User> userMono = serverRequest.bodyToMono(User.class);
		//这里的map方法就是java的链式编程，返回这个方法的返回值, lambda表达式
		//这里flux采用的是异步调用，如果存在多个耗时方法可以节约时间
		Mono<Boolean> booleanMono = userMono.map(userRepository::addUser);
		//Mono<Boolean> booleanMono = userMono.map(user -> userRepository.addUser(user));
		return ServerResponse.ok().body(booleanMono,Boolean.class);
	}
}
