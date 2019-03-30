package com.lcydream.project.springbootjdbc.controller;

import com.lcydream.project.springbootjdbc.domain.User;
import com.lcydream.project.springbootjdbc.repository.UserRepository;
import com.lcydream.project.springbootjdbc.threadpool.CustomThreadPoolExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * UserController
 * SpringMVC模式下的控制器
 * @author Luo Chun Yun
 * @date 2018/11/24 19:36
 */
@RestController
public class UserController {

	private UserRepository userRepository;

	/**
	 * 构造方法注入值
	 * @param userRepository 用户仓储
	 */
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/web/mvc/user/save")
	public Object saveUser(@RequestBody User user){
		/*ExecutorService executorService =
				CustomThreadPoolExecutor.getCustomThreadPoolExecutor();
		Future<Boolean> future = executorService.submit(()
				-> userRepository.addUser(user));
		return future.get();*/
		System.out.printf("[SpringMVC Thread: %s ]\n",
				Thread.currentThread().getName());
		return userRepository.addUser(user);
	}

	@PostMapping("/web/mvc/user/transactionalSaveUser")
	public Object transactionalSaveUser(@RequestBody User user){
		return userRepository.transactionalSaveUser(user);
	}

	@PostMapping("/web/mvc/user/apiSaveUser")
	public Object apiSaveUser(@RequestBody User user){
		return userRepository.apiSaveUser(user);
	}
}
