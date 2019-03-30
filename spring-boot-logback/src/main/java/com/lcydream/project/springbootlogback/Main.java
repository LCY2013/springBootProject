package com.lcydream.project.springbootlogback;

import java.util.Map;

/**
 * Main
 *
 * @author Luo Chun Yun
 * @date 2018/11/26 22:03
 */
public class Main {

  public static void main(String[] args) {
	  Thread thread = Thread.currentThread();
	  Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
	  StackTraceElement[] stackTraceElements = allStackTraces.get(thread);
	  for (StackTraceElement stackTraceElement : stackTraceElements){
        System.out.println(stackTraceElement);
	  }
  }
}
