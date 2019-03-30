package com.lcydream.project.springbootconfiguration.controller;

import com.lcydream.project.springbootconfiguration.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CarController
 *
 * @author Luo Chun Yun
 * @date 2018/11/27 15:04
 */
@RestController
public class CarController {

	@Autowired
	private Car car;

	@GetMapping("/car")
	public Car getCar(){
		return car;
	}
}
