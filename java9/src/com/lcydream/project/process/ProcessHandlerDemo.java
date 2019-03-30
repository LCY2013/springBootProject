package com.lcydream.project.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import static java.lang.System.out;

/**
 * ProcessHandlerDemo
 *
 * @author Luo Chun Yun
 * @date 2018/11/29 16:19
 */
public class ProcessHandlerDemo {

  public static void main(String[] args) {
  	  echoCurrentThreadOnExit();
  	  echoOnExit();
	  echoAllProcesors();
  }

	/**
	 * 当前线程优雅退出
	 */
	private static void echoCurrentThreadOnExit(){
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				//java9
				out.printf("Thread[%d] shutdown is completed\n",ProcessHandle.current().pid());
				//java8 获取运行时的管理扩展Bean
				RuntimeMXBean runtimeMXBean =
						ManagementFactory.getRuntimeMXBean();
				//获取运行管理Bean的名称 name的格式是:pid@xxx
				String name = runtimeMXBean.getName();
				//获取pid
				String pid = name.substring(0,name.indexOf("@"));
				out.printf("Thread[%s] shutdown is completed\n",pid);

			}
		});
    }

	/**
	 * 线程退出信息
	 */
	private static void echoOnExit() {
		ProcessHandle.current().onExit().thenAccept(out::println);
	}

	/**
	 * 获取系统所进程所有线程
	 */
	private static void echoAllProcesors() {
  	    ProcessHandle.allProcesses().forEach(out::println);
	}

}
