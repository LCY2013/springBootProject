package com.lcydream.project.springbootjmx.springbootjmx;

/**
 * Hello
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 17:28
 */
public class Hello implements HelloMBean{

	private String value;

	@Override
	public String greeting() {
		return "hi , magic Luo : value="+value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
