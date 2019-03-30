package com.lcydream.project.springbootbeanvalidation.web.controller;

import com.lcydream.project.springbootbeanvalidation.domain.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * UserController
 * 用户控制器
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 11:14
 */
@RestController
public class UserController {

	@PostMapping("/user/save")
	public User save(@Valid @RequestBody User user){

		return user;
	}

	@PostMapping("/user/saveOne")
	public User saveOne(@Valid @RequestBody User user){

	    // API调用方式
	    Assert.hasText(user.getName(),"名称不能为空");
		//JVM断言
		assert  user.getId() <= 100000;

		return user;
	}
}
