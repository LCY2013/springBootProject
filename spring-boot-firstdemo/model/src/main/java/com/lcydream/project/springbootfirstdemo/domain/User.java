package com.lcydream.project.springbootfirstdemo.domain;

/**
 * User
 * 领域模型，用户模型
 * @author Luo Chun Yun
 * @date 2018/12/1 16:31
 */
public class User {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
