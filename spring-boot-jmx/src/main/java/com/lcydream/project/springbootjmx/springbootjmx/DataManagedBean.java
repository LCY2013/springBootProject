package com.lcydream.project.springbootjmx.springbootjmx;

import javax.management.*;

/**
 * DataManagedBean
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 19:54
 */
public class DataManagedBean implements Data /*extends StandardMBean*/ /*implements DynamicMBean*/ {

	private Long id;

	private String name;

	private Integer age;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getAge() {
		return age;
	}

	@Override
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "DataManagedBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
