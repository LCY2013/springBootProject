package com.lcydream.project.lang;

import java.util.stream.Stream;

import static java.lang.System.*;

/**
 * StackFrameDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/29 17:20
 */
public class StackFrameDemo {

  public static void main(String[] args) {

  	  //前java9
	  echoStackWalker();

	  //java9
	  echoStackTraceElement();
  }

	/**
	 * 栈信息条目
	 */
	private static void echoStackTraceElement() {
		Stream.of(Thread.currentThread().getStackTrace()).forEach(out::println);
	}

	/**
	 * 输出栈信息
	 */
	private static void echoStackWalker(){
	  StackWalker.getInstance().forEach(out::println);
  }
}
