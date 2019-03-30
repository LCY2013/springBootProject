package com.lcydream.project.springbootbeanvalidation.validation.constraints;

import com.lcydream.project.springbootbeanvalidation.validation.ValidCarNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ValidCardNumber
 *
 * <p>合法卡号 校验
 *
 * <p>需求：通过员工的卡号来校验，需要通过工号的前缀和后缀来判断
 *
 * <p>​ 前缀必须以"LUO-"开头
 *
 * <p>​ 后缀必须是数字
 *
 * <p>​ 需要通过Bean Validator校验
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 14:28
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValidCarNumberConstraintValidator.class})
public @interface ValidCardNumber {

	String message() default "{com.lcydream.project.spring.boot.invalid.card.number.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	/**
	 * @return value the element must be lower or equal to
	 */
	String value();

	/**
	 * Defines several {@link Max} annotations on the same element.
	 *
	 * @see Max
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
	@Retention(RUNTIME)
	@Documented
	@interface List {

		ValidCardNumber[] value();
	}
}
