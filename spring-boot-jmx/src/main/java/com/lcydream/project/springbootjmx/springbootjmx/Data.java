package com.lcydream.project.springbootjmx.springbootjmx;

/**
 * Data
 *
 * @author Luo Chun Yun
 * @date 2018/11/25 19:57
 */
public interface Data {
	Long getId();

	void setId(Long id);

	String getName();

	void setName(String name);

	Integer getAge();

	void setAge(Integer age);

	/**
	 * 重写toString方法
	 * @return
	 */
	@Override
	String toString();
}
