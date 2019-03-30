package com.lcydream.project.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LambdaDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/29 15:22
 */
public class LambdaDemo {

  public static void main(String[] args) {
	  Set<String> set = Set.of("hello","magic","luo");
	  set.forEach(System.out::println);

	  //Set<Integer> setInteger = Set.of(1,2,3,4,5,6,7,8,9,10,11);
	  Set<Integer> setInteger = of(1,2,3,4,5,6,7,8,9,10,11);

	  //stream 串行执行
	  System.out.println(setInteger.stream()
			  .filter(integer -> integer>3)
			  .reduce(Integer::sum).get());

	  //parallelStream 并行执行
	  System.out.println(setInteger.parallelStream()
			  .filter(integer -> integer>3)
			  .reduce(Integer::sum).get());
  }

  private static <T> Set<T> of(T... values){
  	Set<T> retVal = new LinkedHashSet<>(Arrays.asList(values));

	  //Stream.of(values).forEach(retVal::add);
	  //retVal.addAll(Arrays.asList(values));

  	return retVal;
  }

}
