package com.lcydream.project.springbootbeanvalidation.domain;

import com.lcydream.project.springbootbeanvalidation.validation.constraints.ValidCardNumber;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * User
 * 用户模型
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 11:09
 */
public class User {

	@Max(value = 10000)
	private Long id;

	@NotNull
	private String name;

  /** 卡号：规则是 -> LUO-45876
   *  value = "value:卡号不合法,必须以\"LUO-\"开头,以数字结尾", message = "卡号不合法,必须以\"LUO-\"开头,以数字结尾"
   * */
  @ValidCardNumber(value = "卡号不合法")
  private String cardNumber;

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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
