package com.lcydream.project.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 *
 * @author Luo Chun Yun
 * @date 2018/11/23 21:13
 */
@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(){
		return "index";
	}
}
