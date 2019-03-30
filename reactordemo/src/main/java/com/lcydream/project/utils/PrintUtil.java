package com.lcydream.project.utils;

/**
 * PrintUtil
 *
 * @author Luo Chun Yun
 * @date 2018/11/28 15:39
 */
public class PrintUtil {

	public static void println(Object message){
        System.out.printf("Thread->[%s],message->%s\n",
		        Thread.currentThread().getName(),
		        String.valueOf(message));
	}
}
