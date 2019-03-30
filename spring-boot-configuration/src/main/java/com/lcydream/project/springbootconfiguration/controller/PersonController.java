package com.lcydream.project.springbootconfiguration.controller;

import com.lcydream.project.springbootconfiguration.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController
 *
 * @author Luo Chun Yun
 * @date 2018/11/27 14:53
 */
@RestController
public class PersonController {

	@Autowired
	private Person person;

	@GetMapping("/person")
	public Person getPerson(){
		return person;
	}
}
