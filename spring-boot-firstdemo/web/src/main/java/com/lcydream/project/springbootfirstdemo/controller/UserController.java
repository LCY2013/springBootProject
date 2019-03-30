package com.lcydream.project.springbootfirstdemo.controller;

import com.lcydream.project.springbootfirstdemo.domain.User;
import com.lcydream.project.springbootfirstdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *  用户 控制器
 * @author Luo Chun Yun
 * @date 2018/12/1 16:29
 */
@RestController
public class UserController {
	//保存使用SpringMVC
	
	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/user/save")
	public User user(@RequestParam String name){
		User user = new User();
		user.setName(name);
		userRepository.save(user);
		return user;
	}
}
