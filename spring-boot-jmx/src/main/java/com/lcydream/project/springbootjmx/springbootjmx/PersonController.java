package com.lcydream.project.springbootjmx.springbootjmx;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonController
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 21:31
 */
@RestController
public class PersonController {

	@GetMapping("/person")
	public Person person(@RequestParam(required = false) String name,
	                     @RequestParam(required = false) String description){
		Person person = new Person();
		if(!StringUtils.isEmpty(name)){
			person.setName(name);
		}
		if(!StringUtils.isEmpty(description)){
			person.setDescription(description);
		}
		return person;
	}
}
