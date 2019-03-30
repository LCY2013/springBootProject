package com.lcydream.project.spring;

import com.lcydream.project.utils.PrintUtil;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * FluxApiDemo
 * Flux 同步操作
 * @author Luo Chun Yun
 * @date 2018/11/29 10:28
 */
public class FluxApiDemo {

  public static void main(String[] args) {
	  Random random = new Random();
	  int randomVal = random.nextInt(6)+1;
	  PrintUtil.println("random:"+randomVal);
    // 订阅并且处理(控制台输出)
    Flux.generate(
            () -> randomVal,
            (value, sink) -> {
              if (value == 5) {
                sink.complete();
              } else {
                sink.next("value = " + value);
              }
              return value + 1;
            })
        .subscribe(PrintUtil::println, PrintUtil::println, () -> System.out.println("subscribe is complete"));
  }

}
