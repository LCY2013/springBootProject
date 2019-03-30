package com.lcydream.project.spring;

import com.lcydream.project.utils.PrintUtil;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * FluxDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/28 15:57
 */
public class FluxDemo {

  public static void main(String[] args) {
		//flux定义
	  //Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
	  //订阅绑定事件
	  //flux.subscribe(PrintUtil::println);

	  //Flux.just(23,54,34,67,89).subscribe(PrintUtil::println);


	  Flux.just(23,54,34,67,89).map((value) -> {
	  	//如果等于67就抛出异常
		  /*if(value == 67){
		  	throw new RuntimeException("this number must less than 67");
		  }*/
		  Random rondom = new Random();
		  if(rondom.nextInt(5) == 3){
		  	throw new RuntimeException("this number must not equals to 3");
		  }
	  	return value+1;
	  }).subscribe(
	  		        //处理数据 onNext()
	  		        PrintUtil::println,
			        //输出异常信息 onError()
			        PrintUtil::println,
			        //完成输出
			        () -> PrintUtil.println("subscribe is complete")
	            );

  }
}
