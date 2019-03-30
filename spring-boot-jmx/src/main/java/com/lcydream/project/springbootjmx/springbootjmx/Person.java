package com.lcydream.project.springbootjmx.springbootjmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * Person
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 21:27
 */
@ManagedResource
@Component
public class Person {

	private String name;

	private String description;

	@ManagedAttribute(defaultValue = "magicLuo",
						description = "名称描述")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
