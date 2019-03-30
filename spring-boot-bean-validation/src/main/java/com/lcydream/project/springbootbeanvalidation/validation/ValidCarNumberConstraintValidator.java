package com.lcydream.project.springbootbeanvalidation.validation;

import com.lcydream.project.springbootbeanvalidation.validation.constraints.ValidCardNumber;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * ValidCarNumberConstraintValidator 实现校验器{@link ConstraintValidator}
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 14:54
 */
public class ValidCarNumberConstraintValidator
    implements ConstraintValidator<ValidCardNumber, String> {

  /**
   * *
   *
   * <p>合法卡号 校验 * *
   *
   * <p>需求：通过员工的卡号来校验，需要通过工号的前缀和后缀来判断 * *
   *
   * <p>​ 前缀必须以"LUO-"开头 * *
   *
   * <p>​ 后缀必须是数字 * *
   *
   * <p>​ 需要通过Bean Validator校验 *
   *
   * @param value 校验的值
   * @param context 验证的结果内容
   * @return 是否验证成功
   */
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // 前半部分和后半部分
    // String[] parts = org.springframework.util.StringUtils.delimitedListToStringArray(value, "-");
    String[] parts = StringUtils.split(value, "-");

    // 为什么不用String#split方法，原因在于该方法使用了正则表达式
    // 其次是NPE保护不够
    // 如果依赖中没有StringUtils.delimitedListToArray API 的话，可以使用
    // Apache commons-lang StringUtils
    // JDK里面StringTokenizer(不足类似于枚举Enumeration API)

    /*if (parts == null || parts.length != 2) {
      return false;
    }*/

    if (ArrayUtils.getLength(parts) != 2) {
      return false;
    }

    String perfix = parts[0];
    String suffix = parts[1];

    boolean isValidPrefix = Objects.equals(perfix, "LUO");
    boolean isValidSuffix = StringUtils.isNumeric(suffix);

    return isValidPrefix && isValidSuffix;
  }

  @Override
  public void initialize(ValidCardNumber constraintAnnotation) {}
}
