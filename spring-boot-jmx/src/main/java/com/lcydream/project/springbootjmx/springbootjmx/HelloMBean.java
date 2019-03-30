package com.lcydream.project.springbootjmx.springbootjmx;

/**
 * HelloMBean
 * jsr中规范的MBean其实现类必须是除去MBean的前面部分
 * @author Luo Chun Yun
 * @date 2018/11/25 17:27
 */
public interface HelloMBean {

	String greeting();

	void setValue(String value);

	String getValue();
}
