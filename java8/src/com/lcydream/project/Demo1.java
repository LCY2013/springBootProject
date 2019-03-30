package com.lcydream.project;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Demo1
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2019/2/20 10:59
 */
public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		//test01();
		//test02();
		//test03();
		TimeUnit.SECONDS.sleep(1000);
	}

	public static  void test04(){
		int k = 0;
		float x = 0;
		long i = 0;
		double j =0;
	}

	public static void test03(){
		int[] test = new int[]{1,2,3,4};
		List<int[]> ints = Arrays.asList(test);
		Arrays.asList(1,2,3,4);
		System.out.println(ints.size());
		System.out.println(ints);
	}

	public static void test02(){
		int j=0;
		for(int i=0;i<100;i++){
			//j = j++; 错误
			j = ++j;
		}
		System.out.println(j);
	}

	public static void test01(){
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		int sum = 1;
		for(int i=0;i<31;i++){
			sum += sum*2;
		}
		System.out.println(Integer.MAX_VALUE / (sum*0.1*10));

		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);

		System.out.println(Double.MIN_NORMAL);
		System.out.println(Double.MAX_VALUE);
	}
}
