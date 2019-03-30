package com.lcydream.project.spring;

import com.lcydream.project.utils.PrintUtil;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * FluxAsyncDemo
 * Flux 异步操作 {@link reactor.core.publisher.Flux}
 * @author Luo Chun Yun
 * @date 2018/11/29 11:15
 */
public class FluxAsyncDemo {

  public static void main(String[] args) throws InterruptedException {
    // 当前线程执行
    /*Flux.range(0, 10)
        .publishOn(Schedulers.immediate())
        .subscribe(
            PrintUtil::println,
            PrintUtil::println,
            () -> System.out.println("subscript is complete"));*/

    //单线程异步执行
	  /*Flux.range(0, 10)
			  .publishOn(Schedulers.single())
			  .subscribe(
					  PrintUtil::println,
					  PrintUtil::println,
					  () -> System.out.println("subscript is complete"));*/
		//弹性线程池异步执行
	  /*Flux.range(0, 10)
			  .publishOn(Schedulers.elastic())
			  .subscribe(
					  PrintUtil::println,
					  PrintUtil::println,
					  () -> System.out.println("subscript is complete"));*/

	  //并行线程池的异步执行
	  Flux.range(0, 10)
			  .publishOn(Schedulers.parallel())
			  .subscribe(
					  PrintUtil::println,
					  PrintUtil::println,
					  () -> System.out.println("subscript is complete"));

		Thread.currentThread().join(1000L);



  }

}
