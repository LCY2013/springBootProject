package com.lcydream.project.springbootjdbc.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * User
 * 这里使用领域驱动模型{@link Repository Domain-Driven Design}
 * @author Luo Chun Yun
 * @date 2018/11/24 16:49
 */
public class User implements Serializable {

	private static final long serialVersionUID = -8887858883150888084L;

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
