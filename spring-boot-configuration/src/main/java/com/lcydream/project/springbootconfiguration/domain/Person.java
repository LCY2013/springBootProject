package com.lcydream.project.springbootconfiguration.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Person
 *
 * @author Luo Chun Yun
 * @date 2018/11/27 14:53
 */
@Component
public class Person {

	@Value("${person.name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
