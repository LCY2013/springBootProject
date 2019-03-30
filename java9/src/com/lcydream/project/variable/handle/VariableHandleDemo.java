package com.lcydream.project.variable.handle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * VariableHandleDemo
 *
 * @author Luo Chun Yun
 * @date 2018/12/1 11:17
 */
public class VariableHandleDemo {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
	  testUnsafe();
	  testVarHandler();
  }

	private static void testVarHandler() throws NoSuchFieldException, IllegalAccessException {
  	  A a = new A();
  	  //这里将a.value 从"Luo" 调整为 "yuan"
		VarHandle varHandle = MethodHandles.lookup().findVarHandle(
				A.class, "value", String.class
		);
        System.out.println(a.value);
		//CAS
		varHandle.compareAndSet(a,"Luo","Yuan");
		System.out.println(a.value);
	}

	private static void testUnsafe() {
  	    //Unsafe.getUnsafe(); 这里有问题，unsafe不能通过代码直接调用

	}

	private static class A{
  	    String value="Luo";
	}
}
